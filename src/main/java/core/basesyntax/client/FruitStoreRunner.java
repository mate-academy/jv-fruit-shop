package core.basesyntax.client;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoCsvImpl;
import core.basesyntax.entity.Operation;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.quantity.handlers.BalanceHandler;
import core.basesyntax.service.quantity.handlers.OperationHandler;
import core.basesyntax.service.quantity.handlers.PurchaseHandler;
import core.basesyntax.service.quantity.handlers.ReturnHandler;
import core.basesyntax.service.quantity.handlers.SupplyHandler;
import java.util.Map;

public class FruitStoreRunner {

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationHandlerMap = Map.of(
                Operation.BALANCE, new BalanceHandler(),
                Operation.SUPPLY, new SupplyHandler(),
                Operation.PURCHASE, new PurchaseHandler(),
                Operation.RETURN, new ReturnHandler());
        FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoCsvImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        ReportService reportService = new ReportServiceImpl(fruitTransactionDao, operationStrategy);
        reportService.generateFinalReport();
    }
}
