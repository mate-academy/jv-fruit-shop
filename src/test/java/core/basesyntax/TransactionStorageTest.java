package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionStorageTest {

    @Test
    public void addAllTestOk() {
        List<FruitTransaction> actualList;
        List<FruitTransaction> expectedList = new ArrayList<>();
        expectedList.add(new FruitTransaction("r","banana",10, LocalDate.parse("2020-10-17")));
        expectedList.add(new FruitTransaction("b","banana",13,LocalDate.parse("2020-10-15")));
        TransactionStorage transactionStorage = new TransactionStorage();
        transactionStorage.addAll(expectedList);
        actualList = transactionStorage.fruitTransactions;
        Assert.assertEquals(expectedList, actualList);
    }
}