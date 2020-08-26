package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;

public class SupplyTransactionTest {
    AbstractTransaction transaction = new SupplyTransaction();

    @Test
    public void getFruitType_correctWork() {
        transaction.setFruitType("banana");
        String actualResult = transaction.getFruitType();
        String expectedResult = "banana";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getDate_correctWork() {
        transaction.setDate(LocalDate.of(2020, 1, 10));
        LocalDate actualResult = transaction.getDate();
        LocalDate expectedResult = LocalDate.of(2020, 1, 10);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getQuantity_correctWork() {
        transaction.setQuantity(1321);
        int actualResult = transaction.getQuantity();
        int expectedResult = 1321;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getTransactionType_correctWork() {
        String actualResult = transaction.getTransactionType();
        String expectedResult = "s";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void setters_correctWork() {
        transaction.setFruitType("banana");
        transaction.setDate(LocalDate.of(2020, 1, 10));
        transaction.setQuantity(120);
        AbstractTransaction newTransaction = new SupplyTransaction();
        newTransaction.setFruitType("banana");
        newTransaction.setDate(LocalDate.of(2020, 1, 10));
        newTransaction.setQuantity(120);
        Assert.assertEquals(newTransaction, transaction);
    }
}
