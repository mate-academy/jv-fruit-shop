package core.basesyntax.service;

import core.basesyntax.AbstractTransaction;
import core.basesyntax.BuyTransaction;
import core.basesyntax.ReturnTransaction;
import core.basesyntax.SupplyTransaction;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionLogServiceTest {
    static TransactionLogService transactionLog = new TransactionLogService();
    static List<AbstractTransaction> transactions = new ArrayList<>();

    @BeforeClass
    public static void setUp() {
        AbstractTransaction supplyTransaction = new SupplyTransaction();
        AbstractTransaction buyTransaction = new BuyTransaction();
        AbstractTransaction returnTransaction = new ReturnTransaction();
        supplyTransaction.setFruitType("banana");
        supplyTransaction.setDate(LocalDate.of(2020, 11, 01));
        supplyTransaction.setQuantity(100);
        buyTransaction.setFruitType("banana");
        buyTransaction.setDate(LocalDate.of(2020, 10, 10));
        buyTransaction.setQuantity(15);
        returnTransaction.setFruitType("banana");
        returnTransaction.setDate(LocalDate.of(2020, 11, 01));
        returnTransaction.setQuantity(2);
        transactions.add(supplyTransaction);
        transactions.add(buyTransaction);
        transactions.add(returnTransaction);
    }

    @Test
    public void logTransactions_correctWork() {
        List<String[]> lines = new ArrayList<>();
        String[] line1 = new String[]{"s", "banana", "100", "2020-11-01"};
        String[] line2 = new String[]{"b", "banana", "15", "2020-10-10"};
        String[] line3 = new String[]{"r", "banana", "2", "2020-11-01"};
        lines.add(line1);
        lines.add(line2);
        lines.add(line3);
        List<AbstractTransaction> expectedResult = transactions;
        List<AbstractTransaction> actualResult = transactionLog.logTransactions(lines);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void logTransactions_absentData() {
        List<String[]> expectedResult = new ArrayList<>();
        List<String[]> lines = new ArrayList<>();;
        List<AbstractTransaction> actualResult = transactionLog.logTransactions(lines);
        Assert.assertEquals(expectedResult, actualResult);
    }
}
