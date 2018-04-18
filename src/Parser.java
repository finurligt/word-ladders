import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Parser {
    public static void main(String[] args) {
        String s = getStringFromStream(System.in);
        System.out.println(s);
    }

    public static String getStringFromStream(InputStream is) {
        Scanner sc = new Scanner(is);
        List<String> lines = new LinkedList();

        while(sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        Optional<String> result = lines.stream().reduce( (s1,s2) -> s1+"\n"+s2);
        return result.orElse("");

    }

}
