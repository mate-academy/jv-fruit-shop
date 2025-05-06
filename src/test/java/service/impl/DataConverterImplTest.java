package service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.DataConverter;

class DataConverterImplTest {
    private DataConverter dataConverter;

    @BeforeEach
    void setUp() {
        dataConverter = new DataConverterImpl();
    }

    @Test
    void convertToTransaction_dataValid_ok() {
        List<String> fruits = new ArrayList<>();
        fruits.add("operation,fruit,quantity");
        fruits.add("b,apple,20");
        fruits.add("b,banana,100");

        List<FruitTransaction> transactions = dataConverter.convertToTransaction(fruits);

        assertEquals(2, transactions.size());
        assertEquals(FruitTransaction.Operation.BALANCE, transactions.get(0).getOperation());
        assertEquals("apple", transactions.get(0).getFruit());
        assertEquals(20, transactions.get(0).getQuantity());

        assertEquals(FruitTransaction.Operation.BALANCE, transactions.get(1).getOperation());
        assertEquals("banana", transactions.get(1).getFruit());
        assertEquals(100, transactions.get(1).getQuantity());
    }

    @Test
    void convertToTransaction_emptyList_ok() {
        List<String> emptyList = new ArrayList<>();

        List<FruitTransaction> transactions = dataConverter.convertToTransaction(emptyList);
        assertEquals(0, transactions.size());
    }

    @Test
    void convertToTransaction_InputNull_notOk() {
        List<String> fruits = null;
        assertThrows(NullPointerException.class, () -> dataConverter.convertToTransaction(fruits));
    }

    @Test
    void convertToTransaction_unknownOperation_notOk() {
        List<String> unknownType = List.of("type,fruit,quantity", "y,banana,100");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> dataConverter.convertToTransaction(unknownType));
        assertEquals("Unknown operation type! y", exception.getMessage());
    }

    @Test
    void convertToTransaction_unknownFormatQuantity_notOk() {
        List<String> unknownQuantity = List.of("type,fruit,quantity", "b,banana,abc");
        assertThrows(NumberFormatException.class,
                () -> dataConverter.convertToTransaction(unknownQuantity));
    }
}
