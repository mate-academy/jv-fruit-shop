package core.basesyntax;

import core.basesyntax.fileservice.FileWriter;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FileWriterTest {
    private static FileWriter writer;
    private Map<String, Integer> output = new HashMap<>();

    @BeforeClass
    public static void setup() {
        writer = new FileWriter();
    }

    @Test
    public void normalWriteTest() {
        output.put("banana", 100);
        output.put("orange", 100);
        output.put("mango", 300);
        output.put("kiwi", 150);
        output.put("blackberries", 400);
        output.put("apricots", 200);
        writer.writeToFile(output,"src/test/resources/output.csv");

        try {
            List<String> expected = null;
            expected = new ArrayList<>(Files.readAllLines(Path.of("src/test/resources/expected.csv")));
            List<String> actual = null;
            actual = new ArrayList<>(Files.readAllLines(Path.of("src/test/resources/output.csv")));
            Assert.assertEquals(expected, actual);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
