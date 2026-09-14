import actions.Action;
import game.GameMap;

import java.util.List;

public class SimulationRunnable implements Runnable{
    private final GameMap map;
    private final List<Action> turnActions;
    private volatile boolean running = false;
    private Thread thread;
    public SimulationRunnable(GameMap map, List<Action> turnActions){
        this.map = map;
        this.turnActions = turnActions;
    }
    @Override
    public void run() {
        while(running){
            for(Action action : turnActions){
                if(!running) return;
                action.perform(map);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                running = false;
            }
        }
    }

    public void start(){
        if(thread != null && thread.isAlive()){
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void stop(){
        running = false;
        if(thread != null){
            thread.interrupt();
        }
    }
}
