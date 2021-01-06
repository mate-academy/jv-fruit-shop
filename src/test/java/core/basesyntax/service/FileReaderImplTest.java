package core.basesyntax.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileReaderImplTest {
    private static FileReader fileReader;

    @BeforeClass
    public static void beforeClass() {
        fileReader = new FileReaderImpl();
    }

    @Test
    public void test() {
        List<String> expected = new ArrayList<>();
        expected.add("b,banana,60");
        expected.add("b,apple,33");
        expected.add("p,banana,76");
        expected.add("s,banana,5");
        expected.add("r,apple,83");
        expected.add("p,apple,87");
        expected.add("p,banana,25");
        expected.add("s,banana,35");
        assertEquals(expected, fileReader.read("src/test/resources/test4.csv"));
    }
}
