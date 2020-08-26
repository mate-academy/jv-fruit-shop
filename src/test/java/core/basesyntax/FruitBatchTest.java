package core.basesyntax;

import org.junit.Test;

import org.junit.Assert;

import java.time.LocalDate;

public class FruitBatchTest {
    FruitBatch fruitBatch = new FruitBatch("banana", LocalDate.of(2020, 11, 12));

    @Test
    public void getFruitType_correctWork() {
        String expectedResult = "banana";
        String actualResult = fruitBatch.getFruitType();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getExpiryDate_correctWork() {
        LocalDate expectedResult = LocalDate.of(2020, 11, 12);
        LocalDate actualResult = fruitBatch.getExpiryDate();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void clone_correctWork() {
        FruitBatch clonedFruitBatch = fruitBatch.clone();
        Assert.assertEquals(clonedFruitBatch, fruitBatch);
    }
}
