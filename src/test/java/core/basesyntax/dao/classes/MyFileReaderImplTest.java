package core.basesyntax.dao.classes;

import static org.junit.Assert.assertEquals;

import core.basesyntax.dao.interfaces.MyFileReader;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MyFileReaderImplTest {
    @Test
    public void inputOk() {
        List<String> expected = new ArrayList<>();
        expected.add("b,banana,15");
        expected.add("b,apple,25");
        expected.add("s,banana,60");
        MyFileReader myFileReader = new MyFileReaderImpl("src/main/resources/inputdata_test.csv");
        assertEquals(expected, myFileReader.readData());
    }
}
