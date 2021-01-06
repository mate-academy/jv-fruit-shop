package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Record;
import core.basesyntax.service.ToRecordParser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CsvToRecordParserTest {
    static ToRecordParser recordParser;

    @BeforeAll
    static void beforeAll() {
        recordParser = new CsvToRecordParser();
    }

    @Test
    void parse_Ok() {
        Record firstRecord = new Record(Operation.BALANCE, new Fruit("banana"), 98L);
        assertEquals(firstRecord, recordParser.parse("b,banana,98"));

        Record secondRecord = new Record(Operation.BALANCE, new Fruit("cherry"), 56L);
        assertEquals(secondRecord, recordParser.parse("b,cherry,56"));

        Record thirdRecord = new Record(Operation.SUPPLY, new Fruit("cherry"), 150L);
        assertEquals(thirdRecord, recordParser.parse("s,cherry,150"));

        Record fourthRecord = new Record(Operation.PURCHASE, new Fruit("banana"), 3L);
        assertEquals(fourthRecord, recordParser.parse("p,banana,3"));

        Record fifthRecord = new Record(Operation.RETURN, new Fruit("banana"), 3L);
        assertEquals(fifthRecord, recordParser.parse("r,banana,3"));
    }

    @Test
    void parseIncorrectSeparator_NotOk() {
        assertThrows(RuntimeException.class, () -> recordParser.parse("b;banana;98"));
    }

    @Test
    void parseIncorrectColumnNumber_NotOk() {
        assertThrows(RuntimeException.class, () -> recordParser.parse("b,banana,98,0.5"));
    }
}
