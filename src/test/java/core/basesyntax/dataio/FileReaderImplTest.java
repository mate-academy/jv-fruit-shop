package core.basesyntax.dataio;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class FileReaderImplTest {
    @Test
    public void inputOk() {
        List<String> expected = new ArrayList<>();
        expected.add("b,banana,15");
        expected.add("b,apple,25");
        expected.add("s,banana,60");
        FileReader fileReader = new FileReaderImpl("src/main/resources/inputdata_test.csv");
        assertEquals(expected, fileReader.read());
    }
}
