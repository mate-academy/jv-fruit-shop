package core.basesyntax;

import core.basesyntax.FruitDto;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.LocalDate;

public class FruitDtoTest {
    private static FruitDto fruitDto = new FruitDto();
    private static final String TRANSACTION_TYPE = "s";
    private static final String TRANSACTION_TYPE_COPY = "s";
    private static final String FRUIT_TYPE = "banana";
    private static final String FRUIT_TYPE_COPY = "banana";
    private static final int QUANTITY = 113;
    private static final int QUANTITY_COPY = 113;
    private static final LocalDate DATE = LocalDate.of(2020, 11, 12);
    private static final LocalDate DATE_COPY = LocalDate.of(2020, 11, 12);

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
        LocalDate expectedResult = DATE;
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

    @Test
    public void hashcode_correctWork() {
        FruitDto fruitDtoOne = new FruitDto();
        fruitDtoOne.setTransaction(TRANSACTION_TYPE);
        fruitDtoOne.setFruitType(FRUIT_TYPE);
        fruitDtoOne.setQuantity(QUANTITY);
        fruitDtoOne.setDate(DATE);
        FruitDto fruitDtoTwo = new FruitDto();
        fruitDtoTwo.setTransaction(TRANSACTION_TYPE);
        fruitDtoTwo.setFruitType(FRUIT_TYPE_COPY);
        fruitDtoTwo.setQuantity(QUANTITY_COPY);
        fruitDtoTwo.setDate(DATE_COPY);
        Assert.assertEquals(fruitDtoOne, fruitDtoTwo);
    }
}