package core.basesyntax.service.file.impl;

import core.basesyntax.service.file.DataWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileWriterTest {
    private static DataWriter writer;

    @BeforeClass
    public static void beforeClass() {
        writer = new FileWriter();
    }

    @Test
    public void testReportFormattingInFile_Ok() {
        String expected = "fruit,quantity" + System.lineSeparator()
                + "apple,90" + System.lineSeparator() + "banana,152";
        List<String> list = List.of("fruit,quantity" + System.lineSeparator(),
                "apple,90" + System.lineSeparator(), "banana,152");
        writer.writeToFile(list, "src/test/resources/ApplesAndBananas.csv");
        String actual;
        try {
            actual = Files.readString(Path.of("src/test/resources/ApplesAndBananas.csv"));
        } catch (IOException e) {
            throw new RuntimeException("Can't correctly read data from file ApplesAndBananas", e);
        }
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void writeToFileSimpleText_Ok() {
        String expected = "The Wise Men will unlearn your name.\n"
                + "Above your head no star will flame.\n"
                + "One weary sound will be the same—\n"
                + "the hoarse roar of the gale.\n"
                + "The shadows fall from your tired eyes\n"
                + "as your lone bedside candle dies,\n"
                + "for here the calendar breeds nights\n"
                + "till...";
        List<String> list = List.of("The Wise Men will unlearn your name.\n",
                "Above your head no star will flame.\n",
                "One weary sound will be the same—\n",
                "the hoarse roar of the gale.\n",
                "The shadows fall from your tired eyes\n",
                "as your lone bedside candle dies,\n",
                "for here the calendar breeds nights\n",
                "till...");
        writer.writeToFile(list, "src/test/resources/SomeText.csv");
        List<String> actual;
        try {
            actual = Files.readAllLines(Path.of("src/test/resources/SomeText.csv"));
        } catch (IOException e) {
            throw new RuntimeException("Can't correctly read data from file SomeText.csv", e);
        }
        Assert.assertEquals(expected, String.join("\n", actual));
    }
}
