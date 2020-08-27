package core.basesyntax.strategy;

import core.basesyntax.FruitStorage;
import core.basesyntax.model.FruitBatch;
import core.basesyntax.model.FruitDto;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.LocalDate;
import java.util.Map;

public class StorageUpdaterStrategyTest {
    private static StorageUpdaterStrategy strategy = new StorageUpdaterStrategy();
    private static FruitDto fruitDtoSupply = new FruitDto();
    private static FruitDto fruitDtoBuy = new FruitDto();
    private static FruitDto fruitDtoReturn = new FruitDto();
    private static Map<FruitBatch, Integer> fruits = FruitStorage.getFruits();
    private static final String TRANSACTION_TYPE_BUY = "b";
    private static final String TRANSACTION_TYPE_SUPPLY = "s";
    private static final String TRANSACTION_TYPE_RETURN = "r";
    private static final String FRUIT_TYPE = "banana";
    private static final String FRUIT_TYPE_TWO = "orange";
    private static final int QUANTITY = 113;
    private static final LocalDate DATE = LocalDate.of(2020, 11, 12);

    @BeforeClass
    public static void setUp() {
        fruitDtoSupply.setTransaction(TRANSACTION_TYPE_SUPPLY);
        fruitDtoSupply.setFruitType(FRUIT_TYPE);
        fruitDtoSupply.setQuantity(QUANTITY);
        fruitDtoSupply.setDate(DATE);
        fruitDtoBuy.setTransaction(TRANSACTION_TYPE_BUY);
        fruitDtoBuy.setFruitType(FRUIT_TYPE);
        fruitDtoBuy.setQuantity(QUANTITY);
        fruitDtoBuy.setDate(DATE);
        fruitDtoReturn.setTransaction(TRANSACTION_TYPE_RETURN);
        fruitDtoReturn.setFruitType(FRUIT_TYPE);
        fruitDtoReturn.setQuantity(QUANTITY);
        fruitDtoReturn.setDate(DATE);
        FruitStorage.clearStock();
    }

    @After
    public void clearStock() {
        FruitStorage.clearStock();
    }

    @Test
    public void apply_supplyCorrectWork() {
        int expectedQuantity = 113;
        strategy.apply(fruitDtoSupply);
        int actualQuantity = fruits.get(new FruitBatch(FRUIT_TYPE, DATE));
        Assert.assertEquals(expectedQuantity, actualQuantity);
    }

    @Test
    public void apply_returnCorrectWork() {
        int expectedQuantity = 113;
        strategy.apply(fruitDtoSupply);
        int actualQuantity = fruits.get(new FruitBatch(FRUIT_TYPE, DATE));
        Assert.assertEquals(expectedQuantity, actualQuantity);
    }

    @Test(expected = RuntimeException.class)
    public void apply_buyAbsentFruit() {
        fruits.put(new FruitBatch(FRUIT_TYPE_TWO, DATE), 114);
        int expectedQuantity = 1;
        strategy.apply(fruitDtoBuy);
        int actualQuantity = fruits.get(new FruitBatch(FRUIT_TYPE, DATE));
        Assert.assertEquals(expectedQuantity, actualQuantity);
    }
}
