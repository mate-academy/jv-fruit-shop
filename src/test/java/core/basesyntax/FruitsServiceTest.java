package core.basesyntax;

import core.basesyntax.service.BuyOperation;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.FruitOperations;
import core.basesyntax.service.FruitsService;
import core.basesyntax.service.SupplyAndReturnOperation;
import core.basesyntax.service.DataToMapParser;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class FruitsServiceTest {
    private static final String INPUT_FILE = "src\\test\\resources\\data.csv";
    private static final String OUT_PUT_FILE = "src\\test\\resources\\result.csv";
    private static final String BUY = "b";
    private static final String SUPPLY = "s";
    private static final String RETURN = "r";
    public static FruitsService shopService;
    private static Map<String, FruitOperations> operationMap;

    @BeforeClass
    public static void beforeClass() {
        shopService = new FruitsService(new CsvFileReader(),
                new CsvFileWriter(), new DataToMapParser());
        operationMap = new HashMap<>();
    }

    @Test
    public void processValidFile() {
        operationMap.put(RETURN, new SupplyAndReturnOperation());
        operationMap.put(SUPPLY, new SupplyAndReturnOperation());
        operationMap.put(BUY, new BuyOperation());
        boolean result = shopService.processFile(INPUT_FILE, OUT_PUT_FILE, operationMap);
        Assert.assertTrue(result);
    }

    @Test
    public void processWithOneOperation() {
        operationMap.put(SUPPLY, new SupplyAndReturnOperation());
        boolean result = shopService.processFile(INPUT_FILE, OUT_PUT_FILE, operationMap);
        Assert.assertTrue(result);
    }
}
