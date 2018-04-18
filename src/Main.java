import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Main {
    public static void main(String[] args) {
        System.out.println("hej");
    }
    public void findPath(Map<String,String[]> G, String s, String t) {
        HashMap<String,String> pred = new HashMap<String,String>();
        HashMap<String,Boolean> visited = new HashMap<String,Boolean>();
        Queue<String> q = new LinkedList<String>();
        q.add(s);
        for (Map.Entry node: G.entrySet()) {
            visited.put((String)node.getKey(), false);
        }
        visited.put(s,true);

    }
}