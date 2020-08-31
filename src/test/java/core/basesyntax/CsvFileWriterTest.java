package core.basesyntax;

import core.basesyntax.service.CsvFileWriter;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvFileWriterTest {
    private static final String OUT_PUT_FILE = "src\\test\\resources\\result.csv";
    private static CsvFileWriter fileWriter;
    private static Map<String, Map<String, Integer>> store;
    private static Map<String, Integer> bananaEntity;

    @BeforeClass
    public static void beforeClass() {
        fileWriter = new CsvFileWriter();
    }

    @Before
    public void beforeEach() {
        store = new HashMap<>();
        bananaEntity = new HashMap<>();
        bananaEntity.put("2020-08-30", 120);
    }

    @AfterClass
    public static void deleteFile() throws IOException {
        Files.delete(Path.of(OUT_PUT_FILE));
    }

    @Test
    public void writeToValidFile() {
        store.put("banana", bananaEntity);
        boolean result = fileWriter.writeToFile(store, OUT_PUT_FILE);
        Assert.assertTrue(result);
        try {
            List<String> actual = Files.readAllLines(Path.of(OUT_PUT_FILE));
            List<String> expected = new ArrayList<>();
            expected.add("banana,120");
            Assert.assertArrayEquals(expected.toArray(), actual.toArray());
        } catch (IOException e) {
            Assert.fail("Cant read created file!");
        }
    }

    @Test
    public void writeEmptyLineTest() {
        boolean result = fileWriter.writeToFile(store, OUT_PUT_FILE);
        Assert.assertTrue(result);
        try {
            String current = Files.readString(Path.of(OUT_PUT_FILE));
            Assert.assertEquals("", current);
        } catch (IOException e) {
            Assert.fail("Cant read created file!");
        }
    }

    @Test
    public void writeSeveralLines() {
        Map<String, Integer> orangeEntity = new HashMap<>();
        orangeEntity.put("2020-08-30", 120);
        store.put("banana", bananaEntity);
        store.put("orange", orangeEntity);
        boolean result = fileWriter.writeToFile(store, OUT_PUT_FILE);
        Assert.assertTrue(result);
        try {
            List<String> current = Files.readAllLines(Path.of(OUT_PUT_FILE));
            List<String> expected = new ArrayList<>();
            expected.add("banana,120");
            expected.add("orange,120");
            Assert.assertArrayEquals(expected.toArray(), current.toArray());
        } catch (IOException e) {
            Assert.fail("Cant read created file");
        }
    }

    @Test(expected = RuntimeException.class)
    public void writeByEmptyPath() {
        fileWriter.writeToFile(store, "");
    }
}
