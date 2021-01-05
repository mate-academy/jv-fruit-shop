package core.basesyntax.service;

import static org.junit.Assert.assertEquals;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.service.operation.Operation;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationStrategy;
import core.basesyntax.service.operation.OperationStrategyImpl;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import core.basesyntax.service.work.with.file.ReadInformationFromFile;
import core.basesyntax.service.work.with.file.ReadInformationFromFileImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ShopServiceImplTest {
    private static String fileName;
    private static FruitService fruitService;
    private static ReadInformationFromFile readInformationFromFile;
    private static ShopService shopService;
    private static Map<Operation.Type, OperationHandler> operationHandlerMap = new HashMap<>();
    private static OperationStrategy operationStrategy;
    private static FruitDao fruitDao;

    @BeforeClass
    public static void beforeClass() throws Exception {
        fruitService = new FruitServiceImpl();
        readInformationFromFile = new ReadInformationFromFileImpl();
        fruitDao = new FruitDaoImpl();
    }

    @Before
    public void beforeAll() {
        operationHandlerMap.put(Operation.Type.R, new ReturnOperationHandler());
        operationHandlerMap.put(Operation.Type.P, new PurchaseOperationHandler());
        operationHandlerMap.put(Operation.Type.S, new SupplyOperationHandler());
        operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        shopService = new ShopServiceImpl(fruitDao, operationStrategy);
    }

    @After
    public void tearDown() throws Exception {
        Storage.fruits.clear();
    }

    @Test
    public void getFruitAmount_Ok() {
        fileName = "database.csv";
        List<String> allLinesFromFile = readInformationFromFile.getAllLines(fileName);
        fruitService.addNewFruit(allLinesFromFile);
        shopService.doOperation(allLinesFromFile);
        assertEquals(152, fruitDao.getAmount("banana"));
        assertEquals(90, fruitDao.getAmount("apple"));
    }
}
