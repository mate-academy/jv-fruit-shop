package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.Assert;
import org.junit.Test;

public class CsvFileWriterImplTest {
    @Test
    public void correctCsvFileWriter() {
        Fruit banana = new Fruit();
        Fruit apple = new Fruit();
        banana.setName("banana");
        apple.setName("apple");
        Storage.fruits.put(banana, 30);
        Storage.fruits.put(apple, 20);
        CsvFileWriterImpl writer = new CsvFileWriterImpl();
        writer.writeData("result.csv");
        String actualResult = readFromFile("result.csv").trim();
        String expectedResult = "fruit,quantity" + System.lineSeparator()
                + "banana,30" + System.lineSeparator()
                + "apple,20";
        Assert.assertEquals(expectedResult, actualResult);
    }

    private String readFromFile(String fileName) {
        try {
            return Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't correctly read data from file " + fileName, e);
        }
    }
}
