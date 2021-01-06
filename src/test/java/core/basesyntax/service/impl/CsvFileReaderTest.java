package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Record;
import core.basesyntax.service.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CsvFileReaderTest {
    static final String PATH_TO_INPUT = "src/test/resources/input.csv";
    static final String INCORRECT_PATH = "src/tessst/ressssources/input.csv";
    static FileReader fileReader;
    static List<Record> expected;
    static List<Record> actual;

    @BeforeAll
    static void beforeAll() {
        fileReader = new CsvFileReader();
        expected = new ArrayList<>();
    }

    @Test
    void readFromCsv_Ok() {
        Record firstRecord = new Record(Operation.BALANCE, new Fruit("banana"), 98L);
        Record secondRecord = new Record(Operation.BALANCE, new Fruit("cherry"), 56L);
        Record thirdRecord = new Record(Operation.SUPPLY, new Fruit("cherry"), 150L);
        Record fourthRecord = new Record(Operation.PURCHASE, new Fruit("banana"), 3L);
        Record fifthRecord = new Record(Operation.RETURN, new Fruit("banana"), 3L);

        expected.add(firstRecord);
        expected.add(secondRecord);
        expected.add(thirdRecord);
        expected.add(fourthRecord);
        expected.add(fifthRecord);

        actual = fileReader.readAll(PATH_TO_INPUT);

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    void readFromCsvIncorrectInput_NotOk() {
        assertThrows(RuntimeException.class, () -> fileReader.readAll(INCORRECT_PATH));
    }
}
