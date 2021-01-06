package core.basesyntax.servise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import core.basesyntax.servise.impl.FilesReaderImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

public class FilesReaderTest {
    private static FilesReader reader;
    private static List<String> expect;

    @BeforeClass
    public static void beforeClass() throws Exception {
        reader = new FilesReaderImpl();
        expect = new ArrayList<>();
        expect.add("b,banana,20");
        expect.add("b,apple,100");
        expect.add("s,banana,100");
        expect.add("p,banana,13");
        expect.add("r,apple,10");
        expect.add("p,apple,20");
        expect.add("p,banana,5");
        expect.add("s,banana,50");
    }

    @Test
    public void readDataFromFile_Ok() {
        assertEquals(expect, reader.readData("src/main/resources/test-fruit.csv"));
    }

    @Test
    public void readDataEmptyList_NotOk() {
        List<String> expect = new ArrayList<>();
        assertNotEquals(expect, reader.readData("src/main/resources/test-fruit.csv"));
    }

    @Test
    public void readDataWrongList_NotOk() {
        List<String> expect = new ArrayList<>();
        expect.add("p,banana,13");
        expect.add("r,apple,10");
        expect.add("p,apple,20");
        assertNotEquals(expect, reader.readData("src/main/resources/test-fruit.csv"));
    }

    @Test(expected = RuntimeException.class)
    public void readDataEmptyFilePath_NotOk() {
        reader.readData("");
    }
}
