package core.basesyntax.services;

import core.basesyntax.services.operations.Buy;
import core.basesyntax.services.operations.Operable;
import core.basesyntax.services.operations.Return;
import core.basesyntax.services.operations.Supply;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class FruitShopServiceTest {
    private static final String FILE_PATH
            = "src/test/resources/testFile.txt";
    private static final String RESULT_FILE_PATH
            = "src/test/resources/resultedTestFile.txt";
    private static final String RETURN = "r";
    private static final String SUPPLY = "s";
    private static final String BUY = "b";
    private static FruitShopService shopService;
    private static Map<String, Operable> operationsMap;

    @Before
    public void before(){
        shopService = new FruitShopService();
        operationsMap = new HashMap<>();
    }

    @Test
    public void fruitShopServiceTest(){
        operationsMap.put(RETURN, new Return());
        operationsMap.put(SUPPLY, new Supply());
        operationsMap.put(BUY, new Buy());
        boolean result = shopService.processFile(FILE_PATH,
                RESULT_FILE_PATH,
                operationsMap);
        Assert.assertTrue(result);
    }

    @Test
    public void withOneOperationTest(){
        operationsMap.put(SUPPLY, new Supply());
        boolean result = shopService.processFile(FILE_PATH,
                RESULT_FILE_PATH,
                operationsMap);
        Assert.assertTrue(result);
    }
}
