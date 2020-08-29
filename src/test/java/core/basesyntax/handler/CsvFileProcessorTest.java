package core.basesyntax.handler;

import core.basesyntax.model.Fruit;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CsvFileProcessorTest {
    CsvFileProcessor processor;

    @Before
    public void init() {
        processor = new CsvFileProcessor();
    }

    @Test
    public void readingFileOk() {
        List<Request> expectedRequests = new ArrayList<>();
        expectedRequests.add(new Request("s", 100
                , new Fruit("banana", LocalDate.parse("2020-10-17"))));
        expectedRequests.add(new Request("s", 15
                , new Fruit("orange", LocalDate.parse("2020-10-17"))));
        expectedRequests.add(new Request("b", 13
                , new Fruit("banana", LocalDate.parse("2020-10-15"))));
        expectedRequests.add(new Request("r", 10
                , new Fruit("banana", LocalDate.parse("2020-10-17"))));
        expectedRequests.add(new Request("s", 100
                , new Fruit("apple", LocalDate.parse("2020-10-17"))));
        expectedRequests.add(new Request("b", 13
                , new Fruit("orange", LocalDate.parse("2020-10-15"))));
        List<Request> actualRequests = processor.read("fruits.csv");

        assertEquals(expectedRequests, actualRequests);
    }

    @Test
    public void writingFileOk() throws IOException {
        List<String> data = new ArrayList<>();
        data.add("orange,2");
        data.add("banana,97");
        data.add("apple,100");

        String fileName = processor.write(data);
        File actualFile = new File(fileName);
        File expectedFile = new File("src/test/resources/fruits2.csv");

        List<String> actual =  Files.readAllLines(actualFile.toPath());
        List<String> expected =  Files.readAllLines(expectedFile.toPath());

        assertEquals(expected, actual);
    }
}
