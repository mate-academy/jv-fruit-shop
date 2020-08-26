package core.basesyntax;

import org.junit.Test;

import org.junit.Assert;

import java.time.LocalDate;

public class FruitBatchTest {
    FruitBatch fruitBatch = new FruitBatch("banana", LocalDate.of(2020, 11, 12));
    private static final String FRUIT_TYPE_ONE = "banana";
    private static final LocalDate EXPIRY_DATE_ONE = LocalDate.of(2020, 11, 12);
    private static final String FRUIT_TYPE_TWO = "banana";
    private static final LocalDate EXPIRY_DATE_TWO = LocalDate.of(2020, 11, 12);

    @Test
    public void getFruitType_correctWork() {
        String expectedResult = FRUIT_TYPE_ONE;
        String actualResult = fruitBatch.getFruitType();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getExpiryDate_correctWork() {
        LocalDate expectedResult = EXPIRY_DATE_ONE;
        LocalDate actualResult = fruitBatch.getExpiryDate();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void clone_correctWork() {
        FruitBatch clonedFruitBatch = fruitBatch.clone();
        Assert.assertEquals(clonedFruitBatch, fruitBatch);
    }

    @Test
    public void hashcode_correctWork() {
        FruitBatch fruitBatchOne = new FruitBatch(FRUIT_TYPE_ONE, EXPIRY_DATE_ONE);
        FruitBatch fruitBatchTwo = new FruitBatch(FRUIT_TYPE_TWO, EXPIRY_DATE_TWO);
        Assert.assertEquals(fruitBatchOne, fruitBatchTwo);
    }
}
