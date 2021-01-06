package core.basesyntax.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import core.basesyntax.db.Warehouse;
import core.basesyntax.model.entities.Fruit;
import core.basesyntax.model.strategy.OperationFactory;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class FruitServiceTest {
    private static final List<String[]> TEST_INPUT = new ArrayList<>();
    private static final List<String[]> TEST_REPORT = new ArrayList<>();
    private static final Fruit TEST_PRODUCT = new Fruit("test");
    private static final Integer TEST_AMOUNT = 10;
    private final FruitService fruitService =
            new FruitService(new OperationFactory<>(Warehouse.getFruitStorage()));

    @BeforeClass
    public static void setUp() {
        TEST_INPUT.add(new String[]{"b", "test", "10"});
        TEST_REPORT.add(new String[]{"test", "10"});
    }

    @Test
    public void importData_ok() {
        fruitService.importData(TEST_INPUT);
        assertTrue("One or more lines should be imported",
                Warehouse.getFruitStorage().size() >= 1);
        assertEquals(TEST_AMOUNT, Warehouse.getFruitStorage().get(TEST_PRODUCT));
    }

    @Test
    public void generateReport_ok() {
        Warehouse.getFruitStorage().put(TEST_PRODUCT, TEST_AMOUNT);
        List<String[]> actualReport = fruitService.generateReport();
        assertArrayEquals("Incorrect report", TEST_REPORT.get(0), actualReport.get(0));
    }

    @After
    public void tearDown() {
        Warehouse.getFruitStorage().clear();
    }
}
