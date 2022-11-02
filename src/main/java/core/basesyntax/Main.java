package core.basesyntax;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.impl.FruitShopDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.operations.BalanceOperationHandler;
import core.basesyntax.service.operations.OperationHandler;
import core.basesyntax.service.operations.PurchaseOperationHandler;
import core.basesyntax.service.operations.SupplyOprationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOprationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new SupplyOprationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);
        fruitShopService.transaction(Path.of("src/main/resources/data.csv"));
        //generate report
        FruitShopDao fruitStorage = new FruitShopDaoImpl();
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        reportGenerator.generateReport(fruitStorage.getAll());
    }
}
