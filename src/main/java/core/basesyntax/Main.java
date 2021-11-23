package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operation.BalanceOperationHandler;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseOperationHandler;
import core.basesyntax.strategy.operation.ReturnOperationHandler;
import core.basesyntax.strategy.operation.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.p, new PurchaseOperationHandler());
        operationHandlerMap.put(Operation.s, new SupplyOperationHandler());
        operationHandlerMap.put(Operation.r, new ReturnOperationHandler());
        operationHandlerMap.put(Operation.b, new BalanceOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        FruitService fruitService = new FruitServiceImpl();
        fruitService.getReportService("src/main/resources/ReportDataDuringWorkingShift.csv",
                "src/main/resources/ReportInTheEndOfTheShift.csv", operationStrategy);
    }
}
