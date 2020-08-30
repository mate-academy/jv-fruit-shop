package core.basesyntax;

import core.basesyntax.fileservice.FileReader;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class ReadFileTest {
    private static FileReader reader;
    private static List<String[]> inputData;

    @BeforeClass
    public static void setup() {
        reader = new FileReader();
        inputData = new ArrayList<>();
    }

    @Test
    public void normalDataTest() {
        List<String[]> expected = new ArrayList<>();
        expected.add((new String[]{"b", "banana","30","2020-10-25"}));
        expected.add((new String[]{"r", "banana","7","2020-12-10"}));
        expected.add((new String[]{"s", "mango","55","2020-12-10"}));
        expected.add((new String[]{"b", "mango", "30", "2020-10-23"}));
        expected.add((new String[]{"r", "banana","8","2020-12-10"}));
        expected.add((new String[]{"s", "blackberries","40","2020-11-15"}));
        expected.add((new String[]{"b", "blackberries","15","2020-10-23"}));
        expected.add((new String[]{"r", "blackberries","5","2020-12-10"}));
        inputData.addAll(reader.read("src/test/resources/input.csv"));
        for (int i = 0; i < expected.size(); i++) {
            Assert.assertEquals(expected.get(i), inputData.get(i));
        }
    }

    @Test(expected = RuntimeException.class)
    public void wrongPath() {
        reader.read("src/test/resources/inputt.csv");
    }
}
