package core.basesyntax;

import core.basesyntax.dao.FruitTransactionDaoCsvImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.handler.BalanceHandler;
import core.basesyntax.service.handler.OperationHandler;
import core.basesyntax.service.handler.PurchaseHandler;
import core.basesyntax.service.handler.ReturnHandler;
import core.basesyntax.service.handler.SupplyHandler;
import core.basesyntax.service.impl.FruitTransactionServiceCsvImpl;
import core.basesyntax.service.impl.ReportServiceCsvImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static final String FILE_NAME = "src/main/resources/transaction.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitTransactionService transactionService =
                new FruitTransactionServiceCsvImpl();
        transactionService.addTransaction(FILE_NAME);
        ReportService reportService =
                new ReportServiceCsvImpl(new FruitTransactionDaoCsvImpl(), operationStrategy);
        reportService.writeReport();
    }
}
