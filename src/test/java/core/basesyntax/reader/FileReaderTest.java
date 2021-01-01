package core.basesyntax.reader;

import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

public class FileReaderTest extends TestCase {
    public void testName() {
        List<String> expected = new ArrayList<>();
        expected.add("b,banana,20");
        expected.add("b,apple,100");
        expected.add("s,banana,100");
        DataReader dataReader = new FileReader("data_for_FR.csv");
        assertEquals(expected, dataReader.readData());
    }
}
