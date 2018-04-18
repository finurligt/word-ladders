import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

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
        Assert.assertEquals("Incorrct path length", 3, steps);
    }

    @Test
    public void badWordShouldFailChild() {
        Main main = new Main();
        boolean res = main.shouldBeChildOf("there", "fucks");
        assertFalse("Bad word passed",res);
    }

    @Test
    public void goodWordShouldPassChild() {
        Main main = new Main();
        boolean res = main.shouldBeChildOf("there", "sheer");
        assertTrue("Good word didn't pass", res);
    }

    @Test
    public void exampleShouldBeLitFam() {
        //climb → blimp → limps → pismo → moist

        assertTrue( Main.shouldBeChildOf("climb", "blimp") );
        assertTrue( Main.shouldBeChildOf("blimp", "limps") );
        assertTrue( Main.shouldBeChildOf("limps", "pismo") );
        assertTrue( Main.shouldBeChildOf("pismo", "moist") );
    }
}
