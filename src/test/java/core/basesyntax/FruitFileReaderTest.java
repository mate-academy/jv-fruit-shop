package core.basesyntax;

import core.basesyntax.service.*;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class FruitFileReaderTest {
    private FruitFileReader reader = new FruitFileReader();

    @Test(expected = RuntimeException.class)
    public void testWrongPath() {
        reader.readFruitFile("src/Tes4t.csv");
    }

    @Test
    public void testRightPath() {
        List<String> actual = reader.readFruitFile("src/PerfectData.csv");
        List<String> expected = new ArrayList<>();
        expected.add("s,banana,100,2020-10-17");
        expected.add("b,banana,13,2020-10-16");
        expected.add("r,banana,10,2020-10-17");
        Assert.assertEquals(actual, expected);
    }
}
