import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {
    public int findPath(Map<String,String[]> neighborMap, String s, String t) {
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
                        //System.err.println("found path "+s+" - "+t);
                        return backTrack(pred,s,t);
                    }
                }
            }
        }
        //System.err.println("found no path s - t");
        return -1;

    }

    private int backTrack(Map<String, String> pred, String s, String t)  {
        int steps = 0;
        String currentNode = t;
        while (true) {
            if (pred.containsKey(currentNode)) {
                currentNode = pred.get(currentNode);
                steps++;

            } else {
                return steps;
            }
        }
    }

    public static boolean shouldBeChildOf(String p, String c) {

        String copyOfChild = String.valueOf(c);

        for(char ac : p.substring(1).toCharArray()) {
            copyOfChild = copyOfChild.replace(String.valueOf(ac), "");
        }

        return copyOfChild.length() == 1;
    }
}
