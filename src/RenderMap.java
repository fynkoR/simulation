import entity.*;

import java.util.ArrayList;
import java.util.List;

public class RenderMap {
    private final String[][] mapRender;

    public RenderMap(int height, int width){
        mapRender = new String[height][width];
    }

    public void render(Map map){
        for(int i = 0; i < mapRender.length; i++){
            for(int j = 0; j < mapRender[0].length; j++){
                mapRender[i][j] = "**";
            }
        }
        List<Position> keyList = new ArrayList<>(map.getMap().keySet());
        for (Position position : keyList) {
            mapRender[position.getX()][position.getY()] = String.valueOf(map.findEntity(position).getIcon());
        }
        print();
    }

    public void print(){
        for(int i = 0; i < mapRender.length; i++){
            for(int j = 0; j < mapRender[0].length; j++){
                System.out.print(mapRender[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
