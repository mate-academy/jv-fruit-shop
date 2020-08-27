package core.basesyntax;

import core.basesyntax.fileservice.WriteToFile;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WriteToFileTest {
    private static WriteToFile writer;
    private Map<String, Integer> output = new HashMap<>();

    @BeforeClass
    public static void setup() {
        writer = new WriteToFile();
    }

    @Test
    public void normalWriteTest() {
        output.put("banana", 100);
        output.put("orange", 100);
        output.put("mango", 300);
        output.put("kiwi", 150);
        output.put("blackberries", 400);
        output.put("apricots", 200);
        writer.writeToFile(output,"src/main/resources/output.csv");

        try {
            List<String> expected = null;
            expected = new ArrayList<>(Files.readAllLines(Path.of("src/main/resources/expected.csv")));
            List<String> actual = null;
            actual = new ArrayList<>(Files.readAllLines(Path.of("src/main/resources/output.csv")));
            Assert.assertEquals(expected, actual);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
