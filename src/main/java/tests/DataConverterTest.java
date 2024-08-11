package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Operation;
import core.basesyntax.service.converter.DataConverter;
import core.basesyntax.service.impl.DataConverterImpl;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataConverterTest {

    private DataConverter dataConverter;

    @BeforeEach
    public void setUp() {
        dataConverter = new DataConverterImpl();
    }

    @Test
    public void convertToTransaction_validData_correctSize() {
        List<String> rawData = Arrays.asList(
                "type,fruit,quantity",
                "b,banana,20",
                "s,banana,100",
                "p,banana,13",
                "r,banana,10"
        );
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(rawData);
        assertEquals(4, transactions.size());
    }

    @Test
    public void convertToTransaction_balanceOperation_ok() {
        List<String> rawData = Arrays.asList(
                "type,fruit,quantity",
                "b,banana,20",
                "s,banana,100",
                "p,banana,13",
                "r,banana,10"
        );
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(rawData);
        FruitTransaction expected = new FruitTransaction();
        expected.setOperation(Operation.BALANCE);
        expected.setFruit("banana");
        expected.setQuantity(20);
        assertEquals(expected, transactions.get(0));
    }

    @Test
    public void convertToTransaction_supplyOperation_ok() {
        List<String> rawData = Arrays.asList(
                "type,fruit,quantity",
                "b,banana,20",
                "s,banana,100",
                "p,banana,13",
                "r,banana,10"
        );
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(rawData);
        FruitTransaction expected = new FruitTransaction();
        expected.setOperation(Operation.SUPPLY);
        expected.setFruit("banana");
        expected.setQuantity(100);
        assertEquals(expected, transactions.get(1));
    }

    @Test
    public void convertToTransaction_purchaseOperation_ok() {
        List<String> rawData = Arrays.asList(
                "type,fruit,quantity",
                "b,banana,20",
                "s,banana,100",
                "p,banana,13",
                "r,banana,10"
        );
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(rawData);
        FruitTransaction expected = new FruitTransaction();
        expected.setOperation(Operation.PURCHASE);
        expected.setFruit("banana");
        expected.setQuantity(13);
        assertEquals(expected, transactions.get(2));
    }

    @Test
    public void convertToTransaction_returnOperation_ok() {
        List<String> rawData = Arrays.asList(
                "type,fruit,quantity",
                "b,banana,20",
                "s,banana,100",
                "p,banana,13",
                "r,banana,10"
        );
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(rawData);
        FruitTransaction expected = new FruitTransaction();
        expected.setOperation(Operation.RETURN);
        expected.setFruit("banana");
        expected.setQuantity(10);
        assertEquals(expected, transactions.get(3));
    }
}
