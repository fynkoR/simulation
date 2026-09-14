package game;

public class RenderMap {

    public static void render(GameMap map){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException exception){
            exception.getStackTrace();
        }
        System.out.println(" ");
        for(int i = 0; i < map.getSize(); i++){
            for(int j =0; j < map.getSize(); j++){
                Position position = new Position(i,j);
                if(map.isEmpty(position)){
                    System.out.print("** ");
                }
                else{
                    System.out.print(map.getEntityByPostion(position).getIcon() + " ");
                }
            }
            System.out.println(" ");
        }
    }
}
