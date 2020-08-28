package core.basesyntax.services;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class FileReaderServiceTest {
 //  @Test
    public static void fileReaderServiceTestOk() {
        FileReaderService fileReaderService = new FileReaderService();
        List<String> result = fileReaderService.readLinesFromFile("src/test/resources/test1.txt");

        Assert.assertEquals(2, result.size());
        Assert.assertEquals("hello world!", result.get(0).trim());
        Assert.assertEquals("I'm test file", result.get(1).trim());
    }

    @Test(expected = RuntimeException.class)
    public void fileReaderServiceTestAbsendFile() {
        FileReaderService fileReaderService = new FileReaderService();
        fileReaderService.readLinesFromFile("src/test/resources/absent_file.txt");
    }
}