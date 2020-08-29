package core.basesyntax.services;

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

public class DataFileWriterTest {
    private static final String FILE_PATH = "src/test/resources/resultedTestFile.csv";
    private static DataFileWriter fileWriter;
    private static Map<String, Map<String, Integer>> store;
    private static Map<String, Integer> bananaEntity;

    @BeforeClass
    public static void beforeClass(){
        fileWriter = new DataFileWriter();
    }

    @Before
    public void beforeEach(){
        store = new HashMap<>();
        bananaEntity = new HashMap<>();
        bananaEntity.put("2020-10-17", 100);
    }

    @AfterClass
    public static void deleteFile() throws IOException {
        Files.delete(Path.of(FILE_PATH));
    }

    @Test
    public void writeToValidFile(){
        store.put("banana", bananaEntity);

        boolean result = fileWriter.writeResultsToFile(store, FILE_PATH);
        Assert.assertTrue(result);

        try {
            List<String> actual = Files.readAllLines(Path.of(FILE_PATH));
            List<String> expected = new ArrayList<>();
            expected.add("banana,100");
            Assert.assertArrayEquals(expected.toArray(), actual.toArray());
        } catch (IOException e) {
            Assert.fail("Cant read created file");
        }
    }

    @Test
    public void writeEmptyLineTest(){
        boolean result = fileWriter.writeResultsToFile(store, FILE_PATH);
        Assert.assertTrue(result);

        try {
            String actual = Files.readString(Path.of(FILE_PATH));
            Assert.assertEquals("", actual);
        } catch (IOException e) {
            Assert.fail("Cant read created file");
        }
    }

    @Test
    public void writeSeveralLines(){
        Map<String, Integer> orangeEntity = new HashMap<>();
        orangeEntity.put("2020-10-18", 50);
        store.put("banana", bananaEntity);
        store.put("orange", orangeEntity);

        boolean result = fileWriter.writeResultsToFile(store, FILE_PATH);
        Assert.assertTrue(result);

        try {
            List<String> actual = Files.readAllLines(Path.of(FILE_PATH));
            List<String> expected = new ArrayList<>();
            expected.add("banana,100");
            expected.add("orange,50");
            Assert.assertArrayEquals(expected.toArray(), actual.toArray());
        } catch (IOException e) {
            Assert.fail("Cant read created file");
        }
    }

    @Test(expected = RuntimeException.class)
    public void writeByEmptyPath(){
        fileWriter.writeResultsToFile(store, "");
    }
}
