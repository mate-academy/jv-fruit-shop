package tests;

import core.basesyntax.DataConverter;
import core.basesyntax.DataConverterImpl;
import core.basesyntax.FruitTransaction;
import core.basesyntax.Operation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
    public void data_converter_size_test() {
        Assertions.assertEquals(4, transactions.size());
    }

    @Test
    public void data_converter_balance_test() {
        FruitTransaction transaction = transactions.get(0);
        Assertions.assertEquals(Operation.BALANCE.getCode(), transaction.getOperation().getCode());
        Assertions.assertEquals("banana", transaction.getFruit());
        Assertions.assertEquals(20, transaction.getQuantity());
    }

    @Test
    public void data_converter_supply_test() {
        FruitTransaction transaction = transactions.get(1);
        Assertions.assertEquals(Operation.SUPPLY.getCode(), transaction.getOperation().getCode());
        Assertions.assertEquals("banana", transaction.getFruit());
        Assertions.assertEquals(100, transaction.getQuantity());
    }

    @Test
    public void data_converter_purchase_test() {
        FruitTransaction transaction = transactions.get(2);
        Assertions.assertEquals(Operation.PURCHASE.getCode(), transaction.getOperation().getCode());
        Assertions.assertEquals("banana", transaction.getFruit());
        Assertions.assertEquals(13, transaction.getQuantity());
    }

    @Test
    public void data_converter_return_test() {
        FruitTransaction transaction = transactions.get(3);
        Assertions.assertEquals(Operation.RETURN.getCode(), transaction.getOperation().getCode());
        Assertions.assertEquals("banana", transaction.getFruit());
        Assertions.assertEquals(10, transaction.getQuantity());
    }
}
