package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handlerimpl.BalanceOperation;
import core.basesyntax.strategy.handlerimpl.PurchaseOperation;
import core.basesyntax.strategy.handlerimpl.ReturnOperation;
import core.basesyntax.strategy.handlerimpl.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_DATA_FILE = "src/main/java/resources/data.csv";
    private static final String REPORT_DATA_FILE = "src/main/java/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperation());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperation());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperation());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperation());

        OperationStrategy strategy = new OperationStrategyImpl(operationHandlerMap);
        ReaderService readerService = new ReaderServiceImpl();
        TransactionService fruitTransform = new TransactionServiceImpl();
        FruitShopService fruitShopService = new FruitShopServiceImpl(strategy);
        ReportService reportService = new ReportServiceImpl();
        WriterService writerService = new WriterServiceImpl();

        List<String> list = readerService.readFromFile(INPUT_DATA_FILE);
        List<FruitTransaction> fruitTransactions = fruitTransform.parseTransactions(list);
        fruitShopService.process(fruitTransactions);
        String reportList = reportService.createReport();
        writerService.writeToFile(REPORT_DATA_FILE, reportList);
    }
}
