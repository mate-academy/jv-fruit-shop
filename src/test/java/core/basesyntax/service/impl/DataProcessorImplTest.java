package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataProcessor;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataProcessorImplTest {

    private static DataProcessor dataProcessor;

    @BeforeEach
    void setUp() {
        dataProcessor = new DataProcessorImpl();
    }

    @Test
    void processAll_validInput_ok() {
        List<String> data = List.of("b,banana,20");
        List<FruitTransaction> expected = List.of(
                new FruitTransaction(Operation.BALANCE, "banana", 20));
        List<FruitTransaction> actual = dataProcessor.processAll(data);
        assertEquals(expected, actual);
    }

    @Test
    void processAll_validLongInput_ok() {
        List<String> data = List.of("type,fruit,quantity",
                "b,banana,20",
                "b,apple,100",
                "s,banana,100",
                "p,banana,13",
                "r,apple,10",
                "p,apple,20",
                "p,banana,5",
                "s,banana,50");
        List<FruitTransaction> expected = List.of(
                new FruitTransaction(Operation.BALANCE, "banana", 20),
                new FruitTransaction(Operation.BALANCE, "apple", 100),
                new FruitTransaction(Operation.SUPPLY, "banana", 100),
                new FruitTransaction(Operation.PURCHASE, "banana", 13),
                new FruitTransaction(Operation.RETURN, "apple", 10),
                new FruitTransaction(Operation.PURCHASE, "apple", 20),
                new FruitTransaction(Operation.PURCHASE, "banana", 5),
                new FruitTransaction(Operation.SUPPLY, "banana", 50)
        );
        List<FruitTransaction> actual = dataProcessor.processAll(data);
        assertEquals(expected, actual);
    }

    @Test
    void processAll_wrongInput_notOk() {
        List<String> data = List.of("wrong");
        assertThrows(RuntimeException.class, () ->
                dataProcessor.processAll(data), "Can't process data: wrong");
    }

    @Test
    void processAll_emptyInput_notOk() {
        assertThrows(RuntimeException.class, () ->
                dataProcessor.processAll(null));
    }

    @Test
    void processAll_negativeQuantity_notOk() {
        List<String> data = List.of("b,banana,-5");
        assertThrows(NumberFormatException.class, () ->
                dataProcessor.processAll(data), "Quantity can't be less than 0, but was: -5");
    }
}
