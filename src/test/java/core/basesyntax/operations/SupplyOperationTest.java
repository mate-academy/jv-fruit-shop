package core.basesyntax.operations;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitDto;
import core.basesyntax.model.FruitStorage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

import java.time.LocalDate;
import java.util.Map;

public class SupplyOperationTest {
    private static final Integer EXPECTED_QUANTITY = 60;
    private static final String KEY = "banana";
    private static Operation supply;
    private static Map<String, Fruit> storage = FruitStorage.getFruitStorage();

    @BeforeClass
    public static void prepareEnvironmentForTests() {
        supply = new SupplyOperation();
    }

    @Before
    public void fillTheStorage() {
        storage.put("banana",
                new Fruit(LocalDate.of(2020, 10, 11), 50));
    }

    @After
    public void clearTheStorage() {
        storage.clear();
    }

    @Test
    public void testSupplyWithExistingFruit() {
        supply.doOperation(
                new FruitDto("s", "banana", "10", "2020-10-07"));
        Assert.assertEquals(EXPECTED_QUANTITY, storage.get(KEY).getAllFruitAmount());
    }

    @Test
    public void testSupplyWithNewFruit() {
        supply.doOperation(
                new FruitDto("s", "orange", "30", "2020-10-07"));
        Assert.assertTrue(storage.size() > 1);
    }
}
