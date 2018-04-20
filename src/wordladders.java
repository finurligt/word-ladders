import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {

    public static void main(String[] args) {
        if(args.length!=2) {
            System.out.println("Wrong number of arguments. please use this program as descipted below:");
            System.out.println("\'java Main <word list file> <paths to find>\'");
            return;
        }

        String wordList = args[0];
        String pathList = args[1];


        List<String> words;
        List<String> path;
        Map<String,List<String>> neighbors = new HashMap<>();
        try {
            words = getStringFromStream(new FileInputStream(wordList));
            path = getStringFromStream(new FileInputStream(pathList));

            for (String parent : words) {
                neighbors.put(parent, new LinkedList<>());
                for (String child : words) {
                    if (shouldBeChildOf(parent,child)) {
                        neighbors.get(parent).add(child);
                    }
                }
            }

            for (String row : path) {
                String[] split = row.split(" ");
                if(split[0].equals(split[1])) {
                    System.out.println(0);
                } else {
                    System.out.println(findPath(neighbors,split[0],split[1]));
                }


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getStringFromStream(InputStream is) {
        Scanner sc = new Scanner(is);
        LinkedList<String> lines = new LinkedList<>();

        while(sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        return lines;

    }

    public static int findPath(Map<String,List<String>> neighborMap, String s, String t) {
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

    private static int backTrack(Map<String, String> pred, String s, String t)  {
        int steps = 0;
        String currentNode = t;
        while (true) {

            if (pred.containsKey(currentNode)) {
                currentNode = pred.get(currentNode);
                steps++;
                //System.err.println(currentNode);
            } else {
                return steps;
            }
        }
    }

    public static boolean shouldBeChildOf(String p, String c) {
        if (c.equals(p)) {
            return false;
        }
        String copyOfChild = String.valueOf(c);

        for(char ac : p.substring(1).toCharArray()) {
            copyOfChild = copyOfChild.replaceFirst(String.valueOf(ac), "");
        }

        return copyOfChild.length() == 1;
    }
}
