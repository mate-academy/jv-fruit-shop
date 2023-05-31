package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FruitShopService;
import service.ReaderService;
import service.ReportService;
import service.TransactionService;
import service.WriterService;
import service.impl.FruitShopServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.TransactionServiceImpl;
import service.impl.WriterServiceImpl;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;
import strategy.handlerimpl.BalanceOperation;
import strategy.handlerimpl.PurchaseOperation;
import strategy.handlerimpl.ReturnOperation;
import strategy.handlerimpl.SupplyOperation;

public class Main {
    private static final String INPUT_DATA_FILE = "src/main/java/resources/fruit_shop_data.csv";
    private static final String REPORT_DATA_FILE = "src/main/java/resources/fruit_shop_report.csv";

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
        writerService.writeToFile(REPORT_DATA_FILE,reportList);
    }
}
