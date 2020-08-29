package core.basesyntax.services;

import core.basesyntax.services.operations.PurchaseOperation;
import core.basesyntax.services.operations.Operable;
import core.basesyntax.services.operations.SupplyOperation;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class FruitShopServiceTest {
    private static final String FILE_PATH = "src/test/resources/testFile.csv";
    private static final String RESULT_FILE_PATH = "src/test/resources/resultedTestFile.csv";
    private static final String RETURN = "r";
    private static final String SUPPLY = "s";
    private static final String BUY = "b";
    private static FruitShopService shopService;
    private static Map<String, Operable> operationsMap;

    @BeforeClass
    public static void beforeClass(){
        shopService = new FruitShopService(new DataFileReader(),
                new DataFileWriter(), new DataToMapParser());
        operationsMap = new HashMap<>();
    }

    @Test
    public void processValidFile(){
        operationsMap.put(RETURN, new SupplyOperation());
        operationsMap.put(SUPPLY, new SupplyOperation());
        operationsMap.put(BUY, new PurchaseOperation());
        boolean result = shopService.processFile(FILE_PATH,
                RESULT_FILE_PATH,
                operationsMap);
        Assert.assertTrue(result);
    }

    @Test
    public void processWithOneOperation(){
        operationsMap.put(SUPPLY, new SupplyOperation());
        boolean result = shopService.processFile(FILE_PATH,
                RESULT_FILE_PATH,
                operationsMap);
        Assert.assertTrue(result);
    }
}
