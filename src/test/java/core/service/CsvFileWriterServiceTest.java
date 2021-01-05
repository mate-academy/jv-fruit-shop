package core.service;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.Before;
import org.junit.Test;

public class CsvFileWriterServiceTest {
    private FileWriterService fileWriterService;

    @Before
    public void beforeClass() {
        fileWriterService = new CsvFileWriterService();
    }

    @Test
    public void testForCorrectData() {
        String expected = "fruit,quantity" + System.lineSeparator() + "This is just a simple test"
                + System.lineSeparator();
        fileWriterService.write("This is just a simple test",
                "src/test/resources/MyPath.csv");
        String actual = readFromFile("src/test/resources/MyPath.csv");
        assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void testForIncorrectName() {
        fileWriterService.write("Hello World", null);
    }

    private String readFromFile(String fileName) {
        try {
            return Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't correctly read data from file " + fileName, e);
        }
    }
}
