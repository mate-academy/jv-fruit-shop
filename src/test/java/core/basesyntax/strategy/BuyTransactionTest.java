package core.basesyntax.strategy;

import core.basesyntax.FruitStorage;
import core.basesyntax.FruitBatch;
import core.basesyntax.FruitDto;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.LocalDate;
import java.util.Map;

public class BuyTransactionTest {
    private static FruitTransaction transaction = new BuyTransaction();
    private static FruitDto fruitDto = new FruitDto();
    private static Map<FruitBatch, Integer> fruits = FruitStorage.getFruits();
    private static final String TRANSACTION_TYPE = "b";
    private static final String FRUIT_TYPE = "banana";
    private static final String WRONG_FRUIT_TYPE = "orange";
    private static final int QUANTITY = 113;
    private static final LocalDate EXPIRY_DATE_ONE = LocalDate.of(2020, 11, 12);
    private static final LocalDate EXPIRY_DATE_TWO = LocalDate.of(2020,11, 13);

    @BeforeClass
    public static void setUp() {
        fruitDto.setTransaction(TRANSACTION_TYPE);
        fruitDto.setFruitType(FRUIT_TYPE);
        fruitDto.setQuantity(QUANTITY);
        fruitDto.setDate(EXPIRY_DATE_ONE);
        FruitStorage.clearStock();
    }

    @After
    public void clearStock() {
        FruitStorage.clearStock();
    }

    @Test
    public void apply_correctWork() {
        fruits.put(new FruitBatch(FRUIT_TYPE, EXPIRY_DATE_TWO), 114);
        int expectedQuantity = 1;
        transaction.apply(fruitDto);
        int actualQuantity = fruits.get(new FruitBatch(FRUIT_TYPE, EXPIRY_DATE_TWO));
        Assert.assertEquals(expectedQuantity, actualQuantity);
    }

    @Test(expected = RuntimeException.class)
    public void apply_notEnoughFruitInStock() {
        fruits.put(new FruitBatch(FRUIT_TYPE, EXPIRY_DATE_TWO), 112);
        transaction.apply(fruitDto);
    }

    @Test(expected = RuntimeException.class)
    public void apply_noSuchFruitInStock() {
        fruits.put(new FruitBatch(WRONG_FRUIT_TYPE, EXPIRY_DATE_TWO), 112);
        transaction.apply(fruitDto);
    }
}
