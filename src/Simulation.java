import actions.*;
import actions.Action;
import game.GameMap;
import game.RenderMap;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Simulation {
    private final GameMap map;
    private List<Action> initActions;
    private List<Action> turnActions;

    public Simulation(GameMap map) {
        this.map = map;
    }

    public void nextTurn() {
        for(Action action : turnActions){
            action.perform(map);
        }
    }


    public void createInitActions() {
        initActions = new ArrayList<>(List.of(
                new GrassSpawnAction(map.getSize()),
                new RockSpawnAction(map.getSize()),
                new TreeSpawnAction(map.getSize()),
                new HerbivoreSpawnAction(map),
                new PredatorSpawnAction(map)
        ));
    }

    public void createTurnActions() {
        turnActions = new ArrayList<>();
        turnActions.add(new MoveCreaturesAction());
        turnActions.add(new GrassSpawnAction(map.getSize()));
        turnActions.add(new HerbivoreSpawnAction(map));
    }

    public List<Action> getInitActions() {
        return initActions;
    }

    public void setInitActions(List<Action> initActions) {
        this.initActions = initActions;
    }

    public List<Action> getTurnActions() {
        return turnActions;
    }

    public void setTurnActions(List<Action> turnActions) {
        this.turnActions = turnActions;
    }
}
