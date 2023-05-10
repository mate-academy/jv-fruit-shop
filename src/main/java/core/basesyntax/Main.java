package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitOperationStrategy;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitOperationStrategyImpl;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.impl.BalanceOperationHandler;
import core.basesyntax.service.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.service.strategy.impl.ReturnOperationHandler;
import core.basesyntax.service.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_NAME = "src/main/resources/data.txt";

    public static void main(String[] args) throws IllegalAccessException {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());

        FruitTransactionService fruitTransactionService = new FruitTransactionServiceImpl();
        FruitOperationStrategy fruitOperationStrategy =
                new FruitOperationStrategyImpl(operationHandlerMap);
        ReportService reportService = new ReportServiceImpl();
        WriterService writerService = new WriterServiceImpl();

        List<FruitTransaction> fruitTransactions = fruitTransactionService
                .getFruitTransactionsFromCvsFile(FILE_NAME);

        for (FruitTransaction fruitTransaction : fruitTransactions) {
            fruitOperationStrategy.put(fruitTransaction).transaction(fruitTransaction);
        }
        String fruitBalanceReport = reportService.createFruitBalanceReport(Storage.fruitBalance);
        writerService.createReportFile(fruitBalanceReport);
    }
}
