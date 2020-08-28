package core.basesyntax.services;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class FileWriterServiceTest {
    @Test
    public void fileWriterServiceTestOk() {
        FileWriterService fileWriterService = new FileWriterService();
        fileWriterService.writeLinesToFile("src/test/resources/file_writer_test_file.txt",
                "Text for FileWriterService test");

        FileReaderService fileReaderService = new FileReaderService();
        List<String> result = fileReaderService.readLinesFromFile(
                "src/test/resources/file_writer_test_file.txt");

        Assert.assertEquals("Text for FileWriterService test", result.get(0).trim());
    }

    @Test(expected = RuntimeException.class)
    public void fileWriterServiceTestNullValue() {
        FileWriterService fileWriterService = new FileWriterService();
        fileWriterService.writeLinesToFile(
                "src/test/resources/file_writer_test_file.txt", null);

        FileReaderService fileReaderService = new FileReaderService();
        fileReaderService.readLinesFromFile("src/test/resources/file_writer_test_file.txt");
    }


    @Test(expected = RuntimeException.class)
    public void fileWriterServiceTestNullFileName() {
        FileWriterService fileWriterService = new FileWriterService();
        fileWriterService.writeLinesToFile(null, "Text for FileWriterService test");

        FileReaderService fileReaderService = new FileReaderService();
        fileReaderService.readLinesFromFile("src/test/resources/file_writer_test_file.txt");
    }

}