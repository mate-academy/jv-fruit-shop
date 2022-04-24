package core.basesyntax.service;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class FileReaderTest {
    //  @Test
    public static void fileReaderServiceTestOk() {
        FileReader fileReaderService = new FileReader();
        List<String> result = fileReaderService.readLinesFromFile("src/test/resources/test2.csv");

        Assert.assertEquals(2, result.size());
        Assert.assertEquals("hello world!", result.get(0).trim());
        Assert.assertEquals("I'm test file", result.get(1).trim());
    }

    @Test(expected = RuntimeException.class)
    public void fileReaderServiceTestAbsendFile() {
        FileReader fileReaderService = new FileReader();
        fileReaderService.readLinesFromFile("src/test/resources/absent_file.csv");
    }
}
