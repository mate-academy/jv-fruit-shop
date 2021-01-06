package core.basesyntax;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Operations;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FruitStorageService;
import core.basesyntax.service.impl.FruitStorageServiceImpl;
import core.basesyntax.service.impl.ReadFromCsvFileImpl;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.strategy.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;

public class FruitStorageServiceTest {
    private static FruitStorageService fruitStorageService;

    @BeforeClass
    public static void setUp() {
        Map<Operations, OperationHandler> operationMap = new HashMap<>();
        operationMap.put(Operations.B, new BalanceHandler());
        operationMap.put(Operations.P, new PurchaseHandler());
        operationMap.put(Operations.R, new ReturnHandler());
        operationMap.put(Operations.S, new SupplyHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationMap);
        fruitStorageService = new FruitStorageServiceImpl(operationStrategy);
    }

    @Test
    public void test1Report_Ok() {
        FileReader reader = new ReadFromCsvFileImpl();
        List<String> data = reader.read("src/test/resources/test1_correct.csv");
        fruitStorageService.saveFruitToStorage(data);
        String actual = fruitStorageService.createReport();
        String expected = "fruit,quantity" + System.lineSeparator()
                + "banana,152" + System.lineSeparator() + "apple,90";
        assertEquals(expected, actual);
        Storage.getStorage().clear();
    }

    @Test
    public void test2Report_Ok() {
        FileReader reader = new ReadFromCsvFileImpl();
        List<String> data = reader.read("src/test/resources/test2_correct.csv");
        fruitStorageService.saveFruitToStorage(data);
        String actual = fruitStorageService.createReport();
        String expected = "fruit,quantity" + System.lineSeparator()
                + "banana,152" + System.lineSeparator() + "apple,90";
        assertEquals(expected, actual);
        Storage.getStorage().clear();
    }

    @Test
    public void test3Report_notOk() {
        try {
            FileReader reader = new ReadFromCsvFileImpl();
            List<String> data = reader.read("src/test/resources/test3_correct.csv");
            fruitStorageService.saveFruitToStorage(data);
            Storage.getStorage().clear();
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), "File was not found");
        }
    }
}
