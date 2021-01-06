package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileWriterImplTest {
    private static FileWriter fileWriter;

    @BeforeClass
    public static void beforeClass() {
        fileWriter = new FileWriterImpl();
    }

    @Test
    public void testWriteReportToFile_Ok() {
        String expected = "fruit,quantity" + System.lineSeparator()
                + "apple,90" + System.lineSeparator() + "banana,152";
        String string = "fruit,quantity" + System.lineSeparator() + "apple,90"
                + System.lineSeparator() + "banana,152";
        fileWriter.writeToFile(string, "src/test/resources/test3.csv");
        String actual;
        try {
            actual = Files.readString(Path.of("src/test/resources/test3.csv"));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWriteLitanyToFile_Ok() {
        String expected = "I must not fear.\nFear is the mind-killer.\n"
                + "Fear is the little-death that brings total obliteration.\n"
                + "I will face my fear.\nI will permit it to pass over me and through me.\n"
                + "And when it has gone past I will turn the inner eye to see its path.\n"
                + "Where the fear has gone there will be nothing.\n"
                + "Only I will remain.";
        String string = "I must not fear.\nFear is the mind-killer.\n"
                + "Fear is the little-death that brings total obliteration.\n"
                + "I will face my fear.\nI will permit it to pass over me and through me.\n"
                + "And when it has gone past I will turn the inner eye to see its path.\n"
                + "Where the fear has gone there will be nothing.\n"
                + "Only I will remain.";
        fileWriter.writeToFile(string, "src/test/resources/LitanyAgainstFear.csv");
        List<String> actual;
        try {
            actual = Files.readAllLines(Path.of("src/test/resources/LitanyAgainstFear.csv"));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        Assert.assertEquals(expected, String.join("\n", actual));
    }
}
