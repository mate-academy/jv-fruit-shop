package core.basesyntax.client;

import core.basesyntax.dao.StoreCsvDao;
import core.basesyntax.dao.StoreCsvDaoImpl;
import core.basesyntax.entity.Operation;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.quantity.handlers.*;

import java.util.HashMap;
import java.util.Map;

public class FruitStoreRunner {

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(Operation.RETURN, new ReturnHandler());
        StoreCsvDao storeCsvDao = new StoreCsvDaoImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        ReportService reportService = new ReportServiceImpl(storeCsvDao,operationStrategy);
        reportService.generateReport();
    }
}
