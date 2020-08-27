package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FileWriterService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileWriterServiceImplTest {
    private static FileWriterService writer;

    @BeforeClass
    public static void setup() {
        writer = new FileWriterServiceImpl();
    }

    @Test
    public void normalWriteTest() {
        List<Fruit> fruits = List.of(
                new Fruit("banana", 100, LocalDate.now()),
                new Fruit("orange", 100, LocalDate.now()),
                new Fruit("kiwi", 100, LocalDate.now()),
                new Fruit("apple", 100, LocalDate.now()),
                new Fruit("pineapple", 100, LocalDate.now()));
        writer.write(fruits, "src/test/resources/normalWriteTest.csv");
        try {
            List<String> expected = new ArrayList<>(Files.readAllLines(Path.of("src/test/resources/expectedFile.csv")));
            List<String> actual = new ArrayList<>(Files.readAllLines(Path.of("src/test/resources/normalWriteTest.csv")));
            Assert.assertEquals(expected, actual);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
