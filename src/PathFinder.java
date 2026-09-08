import java.util.*;

public class PathFinder {

    public List<Position> bfs(Map map, Position start, Position target) {

        if (start == null || target == null) {
            return Collections.emptyList();
        }
        if (start.equals(target)) {
            return new ArrayList<>(List.of(start));
        }
        Queue<Position> queue = new LinkedList<>();
        List<Position> visited = new ArrayList<>();
        HashMap<Position, Position> parents = new HashMap<>();

        queue.add(start);
        visited.add(start);
        parents.put(start, null);

        boolean found = false;

        //Добавление соседа в очередь parents.put(сосед, текущий)

        while(!queue.isEmpty()){
            Position pos = queue.poll();
            if(pos.equals(target)){
                found = true;
                break;
            }
            else{
                List<Position> neighbors = map.getNeighbors(pos);
                for(Position neighbor : neighbors){
                    if(!visited.contains(neighbor) &&
                            (!map.getMap().containsKey(neighbor) || (neighbor.equals(target)))){
                        queue.add(neighbor);
                        visited.add(neighbor);
                        parents.put(neighbor, pos);
                    }
                }
            }
        }
        if(!found){
            return Collections.emptyList();
        }
        else{
            return recoveryPath(parents, target);
        }
    }

    private List<Position> recoveryPath(HashMap<Position, Position> parents, Position target){
        List<Position> path = new ArrayList<>();
        Position current = target;
        while(current != null){
            path.add(current);
            current = parents.get(current);
        }
        Collections.reverse(path);
        return path;
    }
}
