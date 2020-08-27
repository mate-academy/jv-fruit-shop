package core.basesyntax.filereader;

import core.basesyntax.exception.FileReadingException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class LocalFileReaderServiceTest {
    public static final String INPUT_FOLDER = "src/test/resources/input/";
    private static FileReaderService localFileReaderService;
    private List<List<String>> expected;

    @BeforeClass
    public static void beforeClass() {
        localFileReaderService = new LocalFileReaderService();
    }

    @Test
    public void readFileOk() {
        List<String> list1 = Arrays.asList("s,banana,100,2020-10-17".split(","));
        List<String> list2 = Arrays.asList("s,apple,40,2020-10-15".split(","));
        expected = List.of(list1, list2);
        String input = INPUT_FOLDER + "readFileOk.csv";
        Assert.assertEquals(localFileReaderService.readFile(input), expected);
    }

    @Test(expected = FileReadingException.class)
    public void invalidInputPath() {
        String input = INPUT_FOLDER + "notExistingFile.csv";
        localFileReaderService.readFile(input);
    }
}
