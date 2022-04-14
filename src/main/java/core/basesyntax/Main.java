package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.BalanceOperation;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.PurchaseOperation;
import core.basesyntax.operation.ReturnOperation;
import core.basesyntax.operation.SupplyOperation;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReaderServiceImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.TransactionServiceImpl;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_INPUT_NAME = "src/main/resources/input.csv";
    private static final String FILE_REPORT_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        List<FruitTransaction> fruitTransactionList = readerService.read(FILE_INPUT_NAME);
        TransactionService transactionService = new TransactionServiceImpl(operationStrategy);
        transactionService.proceedTransaction(fruitTransactionList);
        ReportService reportService = new ReportServiceImpl();
        WriterService writerService = new WriterServiceImpl();
        writerService.write(reportService.report(), FILE_REPORT_NAME);
    }
}
