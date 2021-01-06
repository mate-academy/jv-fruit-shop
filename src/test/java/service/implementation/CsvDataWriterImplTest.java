package service.implementation;

import static org.junit.Assert.assertEquals;

import db.FruitStorage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Fruit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.DataWriter;

public class CsvDataWriterImplTest {
    public static final String CORRECT_OUTPUT = "src/test/resources/correct_output.csv";
    public static final String EXPECTED_OUTPUT = "src/test/resources/expected_output.csv";
    private static final Map<Fruit, Integer> testFruits = new HashMap<>();
    private final DataWriter dataWriter = new CsvDataWriterImpl();

    @Before
    public void setUp() {
        testFruits.put(new Fruit("cherry"), 50);
        testFruits.put(new Fruit("banana"), 108);
        testFruits.put(new Fruit("apple"), 213);
        testFruits.put(new Fruit("durian"), 70);
    }

    @Test
    public void writeToFile_validInput_Ok() {
        dataWriter.writeToFile(testFruits, EXPECTED_OUTPUT);
        List<String> actual;
        List<String> expected;
        try {
            actual = Files.readAllLines(Path.of(CORRECT_OUTPUT));
            expected = Files.readAllLines(Path.of(EXPECTED_OUTPUT));
        } catch (IOException e) {
            throw new RuntimeException("Can not read from file: " + CORRECT_OUTPUT);
        }
        assertEquals(actual, expected);
    }

    @After
    public void tearDown() {
        FruitStorage.fruitStorage.clear();
    }
}
