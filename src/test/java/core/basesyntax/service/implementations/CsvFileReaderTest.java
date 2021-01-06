package core.basesyntax.service.implementations;

import core.basesyntax.service.FileReader;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvFileReaderTest {
    public static final String EMPTY_FILE_PATH = "src/test/resources/FileReaderTest.csv";
    public static FileReader reader;

    @BeforeClass
    public static void initialize() {
        reader = new CsvFileReader();
    }

    @Test(expected = RuntimeException.class)
    public void emptyFile_ThrowsException() {
        reader.getAllLines(EMPTY_FILE_PATH);
    }

    @Test(expected = RuntimeException.class)
    public void wrongPath_ThrowsException() {
        reader.getAllLines("FUUUUUUUUUUUUUU");
    }

    @Test
    public void getAllLines_Correct() {
        List<String> list = reader.getAllLines("src/test/resources/test1.csv");
        List<String> expected = List.of("b,banana,20", "b,apple,100", "s,banana,100",
                "p,banana,13", "r,apple,10", "p,apple,20", "p,banana,5", "s,banana,50");
        Assert.assertEquals(expected, list);
    }
}
