package core.basesyntax.operations;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitDto;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import java.time.LocalDate;
import java.util.Map;

public class ReturnOperationTest {
    private static final Integer EXPECTED_QUANTITY = 60;
    private static final String KEY = "banana";
    private static Operation returning;
    private static Map<String, Fruit> storage = Fruit.getFruitStorage();

    @BeforeClass
    public static void prepareEnvironmentBeforeTest() {
        storage.clear();
        returning = new ReturnOperation();
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
    public void testNormalReturn() {
        returning.doOperation(
                new FruitDto("r", "banana", "10", "2020-10-07"));
        Assert.assertEquals(EXPECTED_QUANTITY, storage.get(KEY).getAllFruitAmount());
    }

    @Test(expected = RuntimeException.class)
    public void testReturnNonExistingFruit() {
        returning.doOperation(
                new FruitDto("r", "potato", "200", "2020-10-07"));
    }
}
