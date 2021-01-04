package core.basesyntax.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
import core.basesyntax.service.work.with.file.Report;
import core.basesyntax.service.work.with.file.ReportImpl;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ShopServiceImplTest {
    static FruitDao fruitDao = new FruitDaoImpl();
    static Map<Operation.Type, OperationHandler> operationHandlerMap = new HashMap<>();
    static OperationStrategy operationStrategy;
    static ShopService shopService;
    static Report report;

    @BeforeAll
    static void beforeAll() {
        operationHandlerMap.put(Operation.Type.R, new ReturnOperationHandler());
        operationHandlerMap.put(Operation.Type.P, new PurchaseOperationHandler());
        operationHandlerMap.put(Operation.Type.S, new SupplyOperationHandler());
        operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        shopService = new ShopServiceImpl(fruitDao, operationStrategy);
        report = new ReportImpl();
    }

    @Test
    void getFruitAmount_Ok() {
        report.createReport("database.csv");
        assertEquals(152, Storage.fruits.get(0).getAmount());
        assertEquals(90, Storage.fruits.get(1).getAmount());
        Storage.fruits.clear();
    }
}
