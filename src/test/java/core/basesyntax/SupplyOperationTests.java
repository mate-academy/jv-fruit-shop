package core.basesyntax;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitOperations;
import core.basesyntax.service.impl.SupplyFruitOperation;
import org.junit.*;

import java.time.LocalDate;
import java.util.Map;

public class SupplyOperationTests {
    private static final Integer EXPECTED_QUANTITY = 60;
    private static final String KEY = "banana";
    private static FruitOperations supply;
    private static Map<String, Fruit> storage = Fruit.getFruitStorage();

    @BeforeClass
    public static void prepareEnvironmentForTests() {
        supply = new SupplyFruitOperation();
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
