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

public class SupplyTransactionTest {
    private static FruitTransaction transaction = new SupplyTransaction();
    private static FruitDto fruitDto = new FruitDto();
    private static Map<FruitBatch, Integer> fruits = FruitStorage.getFruits();
    private static final String TRANSACTION_TYPE = "s";
    private static final String FRUIT_TYPE = "banana";
    private static final int QUANTITY = 3;
    private static final LocalDate EXPIRY_DATE_ONE = LocalDate.of(2020, 11, 12);

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
        fruits.put(new FruitBatch(FRUIT_TYPE, EXPIRY_DATE_ONE), 10);
        int expectedQuantity = 13;
        transaction.apply(fruitDto);
        int actualQuantity = fruits.get(new FruitBatch(FRUIT_TYPE,
                EXPIRY_DATE_ONE));
        Assert.assertEquals(expectedQuantity, actualQuantity);
    }
}
