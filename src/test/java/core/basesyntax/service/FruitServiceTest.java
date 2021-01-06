package core.basesyntax.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import core.basesyntax.db.Warehouse;
import core.basesyntax.model.OperationFactory;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class FruitServiceTest {
    private static final List<String[]> TEST_INPUT = new ArrayList<>();
    private static final List<String[]> TEST_REPORT = new ArrayList<>();
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
    }

    @Test
    public void generateReport_ok() {
        fruitService.importData(TEST_INPUT);
        List<String[]> actualReport = fruitService.generateReport();
        assertArrayEquals(TEST_REPORT.get(0), actualReport.get(0));
    }

    @After
    public void tearDown() {
        Warehouse.getFruitStorage().clear();
    }
}
