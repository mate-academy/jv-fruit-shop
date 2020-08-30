package core.basesyntax.service;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class FileWriterTest {
    @Test
    public void fileWriterServiceTestOk() {
        FileWriter fileWriterService = new FileWriter();
        fileWriterService.writeLinesToFile("src/test/resources/file_writer_test_file.csv",
                "Text for FileWriterService test");

        FileReader fileReaderService = new FileReader();
        List<String> result = fileReaderService.readLinesFromFile(
                "src/test/resources/file_writer_test_file.csv");

        Assert.assertEquals("Text for FileWriterService test", result.get(0).trim());
    }

    @Test(expected = RuntimeException.class)
    public void fileWriterServiceTestNullValue() {
        FileWriter fileWriterService = new FileWriter();
        fileWriterService.writeLinesToFile(
                "src/test/resources/file_writer_test_file.csv", null);

        FileReader fileReaderService = new FileReader();
        fileReaderService.readLinesFromFile("src/test/resources/file_writer_test_file.csv");
    }


    @Test(expected = RuntimeException.class)
    public void fileWriterServiceTestNullFileName() {
        FileWriter fileWriterService = new FileWriter();
        fileWriterService.writeLinesToFile(null, "Text for FileWriterService test");

        FileReader fileReaderService = new FileReader();
        fileReaderService.readLinesFromFile("src/test/resources/file_writer_test_file.csv");
    }

}