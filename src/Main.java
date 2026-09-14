import actions.*;
import game.GameMap;
import game.RenderMap;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException{


        GameMap map = new GameMap(10);
        Simulation simulation = new Simulation(map);
        simulation.createInitActions();
        simulation.createTurnActions();
        List<Action> initActions = simulation.getInitActions();
        for(Action action : initActions){
            action.perform(map);
        }

        SimulationRunnable simulationRunnable = new SimulationRunnable(map, simulation.getTurnActions());

        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        while(check){
            String str = scanner.next();
            switch (str){
                case "1":
                    simulationRunnable.start();
                    break;
                case "2":
                    simulationRunnable.stop();
                    break;
                case "3":
                    simulationRunnable.stop();
                    check = false;
                    break;

            }
        }
    }

}