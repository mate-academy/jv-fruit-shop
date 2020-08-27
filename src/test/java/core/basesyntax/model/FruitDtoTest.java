package core.basesyntax.model;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.LocalDate;

public class FruitDtoTest {
    private static FruitDto fruitDto = new FruitDto();
    private static final String TRANSACTION_TYPE = "s";
    private static final String FRUIT_TYPE = "banana";
    private static final int QUANTITY = 113;
    private static final LocalDate EXPIRY_DATE = LocalDate.of(2020, 11, 12);

    @BeforeClass
    public static void setUp() {
        fruitDto.setTransaction("s");
        fruitDto.setFruitType("banana");
        fruitDto.setQuantity(113);
        fruitDto.setDate(LocalDate.of(2020, 11, 12));
    }

    @Test
    public void getFruitType_correctWork() {
        String expectedResult = FRUIT_TYPE;
        String actualResult = fruitDto.getFruitType();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getDate_correctWork() {
        LocalDate expectedResult = EXPIRY_DATE;
        LocalDate actualResult = fruitDto.getDate();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getTransaction_correctWork() {
        String expectedResult = TRANSACTION_TYPE;
        String actualResult = fruitDto.getTransaction();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getQuantity_correctWork() {
        int expectedResult = QUANTITY;
        int actualResult = fruitDto.getQuantity();
        Assert.assertEquals(expectedResult, actualResult);
    }
}