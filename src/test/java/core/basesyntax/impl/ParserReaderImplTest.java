package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.util.ParserReader;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParserReaderImplTest {
    private final ParserReader parserReader = new ParserReaderImpl();
    private final FruitTransaction fruit1 = new FruitTransaction(FruitTransaction
            .Operation.BALANCE, "banana", 20);
    private final FruitTransaction fruit2 = new FruitTransaction(FruitTransaction
            .Operation.BALANCE, "apple", 100);
    private final FruitTransaction fruit3 = new FruitTransaction(FruitTransaction
            .Operation.SUPPLY, "banana", 100);
    private final FruitTransaction fruit4 = new FruitTransaction(FruitTransaction
            .Operation.PURCHASE, "banana", 13);
    private final List<String> records = new ArrayList<>();

    @Test
    void parsedToFruitTransaction_Ok() {
        records.add("type,fruit,quantity");
        records.add("   b,banana,20");
        records.add("   b,apple,100");
        records.add("    s,banana,100");
        records.add("  p,banana,13");
        List<FruitTransaction> expected = new ArrayList<>();
        expected.add(fruit1);
        expected.add(fruit2);
        expected.add(fruit3);
        expected.add(fruit4);
        List<FruitTransaction> actual = parserReader.parsedToFruitTransaction(records);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void parsedToFruitTransaction_notTransactions_Ok() {
        records.add("type,fruit,quantity");
        Assertions.assertTrue(parserReader.parsedToFruitTransaction(records).isEmpty());
    }

    @Test
    void parsedToFruitTransaction_notList_Ok() {
        Assertions.assertTrue(parserReader.parsedToFruitTransaction(records).isEmpty());
    }

    @Test
    void parsedToFruitTransaction_OperationNotExist_NotOk() {
        records.add("type,fruit,quantity");
        records.add("c,banana,20");
        Assertions.assertThrows(RuntimeException.class, () ->
                parserReader.parsedToFruitTransaction(records));
    }

    @Test
    void parsedToFruitTransaction_withWrongTransaction_NotOk() {
        records.add("type,fruit,quantity");
        records.add("b,banana,notNumber");
        Assertions.assertThrows(NumberFormatException.class, () ->
                parserReader.parsedToFruitTransaction(records));
    }
}
