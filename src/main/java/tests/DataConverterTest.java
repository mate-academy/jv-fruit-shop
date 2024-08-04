package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Operation;
import core.basesyntax.service.converter.DataConverter;  // Assuming this is needed
import core.basesyntax.service.impl.DataConverterImpl;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class DataConverterTest {

    private final List<String> rawData = Arrays.asList(
            "type,fruit,quantity",
            "b,banana,20",
            "s,banana,100",
            "p,banana,13",
            "r,banana,10"
    );

    private final DataConverter dataConverter = new DataConverterImpl();
    private final List<FruitTransaction> transactions = dataConverter.convertToTransaction(rawData);

    @Test
    public void dataConverterSizeTest() {
        assertEquals(4, transactions.size());
    }

    @Test
    public void dataConverterBalanceTest() {
        FruitTransaction transaction = transactions.get(0);
        assertEquals(Operation.BALANCE.getCode(), transaction.getOperation().getCode());
        assertEquals("banana", transaction.getFruit());
        assertEquals(20, transaction.getQuantity());
    }

    @Test
    public void dataConverterSupplyTest() {
        FruitTransaction transaction = transactions.get(1);
        assertEquals(Operation.SUPPLY.getCode(), transaction.getOperation().getCode());
        assertEquals("banana", transaction.getFruit());
        assertEquals(100, transaction.getQuantity());
    }

    @Test
    public void dataConverterPurchaseTest() {
        FruitTransaction transaction = transactions.get(2);
        assertEquals(Operation.PURCHASE.getCode(), transaction.getOperation().getCode());
        assertEquals("banana", transaction.getFruit());
        assertEquals(13, transaction.getQuantity());
    }

    @Test
    public void dataConverterReturnTest() {
        FruitTransaction transaction = transactions.get(3);
        assertEquals(Operation.RETURN.getCode(), transaction.getOperation().getCode());
        assertEquals("banana", transaction.getFruit());
        assertEquals(10, transaction.getQuantity());
    }
}
