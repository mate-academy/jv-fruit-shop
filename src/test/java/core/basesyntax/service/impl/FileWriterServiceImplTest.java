package core.basesyntax.service.impl;

import core.basesyntax.Storage;
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
        List<Storage.FruitBox> fruits = List.of(
                new Storage.FruitBox(new Fruit("banana", LocalDate.now()), 100),
                new Storage.FruitBox(new Fruit("orange", LocalDate.now()), 100),
                new Storage.FruitBox(new Fruit("apple", LocalDate.now()), 100),
                new Storage.FruitBox(new Fruit("kiwi", LocalDate.now()), 100),
                new Storage.FruitBox(new Fruit("pineapple", LocalDate.now()), 100));
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
