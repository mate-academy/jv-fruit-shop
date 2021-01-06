package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvFileWriterTest {
    private static FilesWriter filesWriter;
    private static final String file = "src/test/resources/report.csv";
    private static Map<Fruit, Integer> data;

    @BeforeClass
    public static void initialization() {
        filesWriter = new CsvFileWriter();
        data = new HashMap<>();
        data.put(new Fruit("banana"), 150);
        data.put(new Fruit("apple"), 50);
    }

    @Test
    public void write_correctData_ok() {
        filesWriter.write(data, file);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            bufferedReader.readLine();
            Assert.assertEquals("banana,150", bufferedReader.readLine());
            Assert.assertEquals("apple,50", bufferedReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException("Error writing data!");
        }
    }

    @Test(expected = RuntimeException.class)
    public void write_incorrectPath_notOk() {
        filesWriter.write(data, "");
    }
}
