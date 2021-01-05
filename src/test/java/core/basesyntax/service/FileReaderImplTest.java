package core.basesyntax.service;

import java.nio.file.Path;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileReaderImplTest {
    private static FileReader fileReader;
    private String badFileName = "src/test/resources/inputfileTestt.csv";
    private String normalFileName = "src/test/resources/inputfileTest.csv";
    private String[] expectedArray = new String[]{"b,banana,100",
            "b,apple,100",
            "s,banana,200",
            "s,apple,300",
            "p,apple,150",
            "p,banana,120",
            "r,banana,50",
            "r,apple,10"};

    @BeforeClass
    public static void beforeClass() throws Exception {
        fileReader = new FileReaderImpl();
    }

    @Test(expected = RuntimeException.class)
    public void whenBadPath_expectException() {
        fileReader.readFromFile(Path.of(badFileName));
    }

    @Test
    public void whenNormalFile_expectedList() {
        List<String> strings = fileReader.readFromFile(Path.of(normalFileName));
        String[] actual = new String[strings.size()];
        actual = strings.toArray(actual);
        Assert.assertArrayEquals(expectedArray, actual);
    }
}
