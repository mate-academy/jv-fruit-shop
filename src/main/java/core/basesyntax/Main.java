package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FruitShopService;
import service.ParseService;
import service.ReaderFileService;
import service.ReportService;
import service.TransactionStrategy;
import service.WriterFileService;
import service.activities.BalanceTransactionHandler;
import service.activities.PurchaseTransactionHandler;
import service.activities.ReturnTransactionHandler;
import service.activities.SupplyTransactionHandler;
import service.activities.TransactionHandler;
import service.impl.FruitShopServiceImpl;
import service.impl.ParseServiceImpl;
import service.impl.ReaderFileServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.TransactionStrategyImpl;
import service.impl.WriterFileServiceImpl;

public class Main {
    private static final String FILE_NAME_INPUT = "src/main/resources/input.csv";
    private static final String FILE_NAME_OUTPUT = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, TransactionHandler> activitiesHandlerMap = new HashMap<>();
        activitiesHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceTransactionHandler());
        activitiesHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseTransactionHandler());
        activitiesHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnTransactionHandler());
        activitiesHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyTransactionHandler());

        ReaderFileService readerFileService = new ReaderFileServiceImpl();
        List<String> listFromFile = readerFileService.readFromFile(FILE_NAME_INPUT);

        TransactionStrategy activitiesStrategy = new TransactionStrategyImpl(activitiesHandlerMap);
        ParseService parseService = new ParseServiceImpl();

        List<FruitTransaction> transactions = parseService.parseTransactions(listFromFile);

        FruitShopService fruitShopService = new FruitShopServiceImpl(activitiesStrategy);
        fruitShopService.handleTransactions(transactions);

        ReportService reportService = new ReportServiceImpl();

        List<String> report = reportService.createReport();
        WriterFileService writerFileService = new WriterFileServiceImpl();
        writerFileService.writeToFile(report, FILE_NAME_OUTPUT);
    }

}
