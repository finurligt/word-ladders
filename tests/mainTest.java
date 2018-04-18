import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class mainTest {
    @Before
    public void setUp() {

    }

    @Test
    public void bothWaysTest() {
        HashMap<String, String[]> dataStructure = new HashMap<String, String[]>();

        // a - b
        // |
        // c - e
        // |   |
        // d   f

        String[] aNeighbors = {"c","b"};
        String[] bNeighbors = {"a"};
        String[] cNeighbors = {"a","e","d"};
        String[] dNeighbors = {"c"};
        String[] eNeighbors = {"c","f"};
        String[] fNeighbors = {"e"};


        dataStructure.put("a", aNeighbors);
        dataStructure.put("b", bNeighbors);
        dataStructure.put("c", cNeighbors);
        dataStructure.put("d", dNeighbors);
        dataStructure.put("e", eNeighbors);
        dataStructure.put("f", fNeighbors);

        Main m = new Main();
        int steps = m.findPath(dataStructure,"a","f");
        Assert.assertEquals("Incorrect path length", 3, steps);


    }
}
