package core.basesyntax;

import core.basesyntax.dao.FruitTransactionDaoCsvImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FruitTransactionServiceCsvImpl;
import core.basesyntax.service.impl.ReportServiceCsvImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handler.BalanceHandler;
import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.strategy.handler.PurchaseHandler;
import core.basesyntax.strategy.handler.ReturnHandler;
import core.basesyntax.strategy.handler.SupplyHandler;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final String File_Name = "src/main/resources/transaction.csv";
        final String Report_Path = "src/main/resources/report.csv";
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitTransactionService transactionService =
                new FruitTransactionServiceCsvImpl();
        transactionService.addTransaction(File_Name);
        ReportService reportService =
                new ReportServiceCsvImpl(new FruitTransactionDaoCsvImpl(), operationStrategy);
        reportService.writeReport(Report_Path);
    }
}
