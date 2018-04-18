import java.util.*;

class Main {
    public static void main(String[] args) {
        System.out.println("hej");
    }
    public void findPath(Map<String,String[]> neighborMap, String s, String t) {
        HashMap<String,String> pred = new HashMap<String,String>();
        HashSet<String> visited = new HashSet<String>();

        //q <- new list containing s
        Queue<String> q = new LinkedList<String>();
        q.add(s);

        //for v ∈ V visited(v) ← 0

        //visited(s) ← 1
        visited.add(s);

        //while q 6= null
        while(!q.isEmpty()) {
            //v ← take out the first element from q
            String currentNode = q.poll();
            //for w ∈ neighbor(v)
            for (String neighbor : neighborMap.get(currentNode)) {
                //if not visited(w) then
                if (!visited.contains(neighbor)) {
                    //visited(w) ← 1
                    visited.add(neighbor);
                    //add w to end of q
                    q.add(neighbor);
                    //pred(w) ← v
                    pred.put(neighbor,currentNode);
                    //if w = t then
                    if (neighbor.equals(t)) {
                        System.out.println("found path s - t");
                        return;
                    }
                }
            }
        }
        System.out.println("found no path s - t");
    }
}