package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.ActivitiesStrategy;
import service.FruitShopService;
import service.ReaderFileService;
import service.ReportService;
import service.WriterFileService;
import service.activities.BalanceTransactionHandler;
import service.activities.PurchaseTransactionHandler;
import service.activities.ReturnTransactionHandler;
import service.activities.SupplyTransactionHandler;
import service.activities.TransactionHandler;
import service.impl.ActivitiesStrategyImpl;
import service.impl.FruitShopServiceImpl;
import service.impl.ReaderFileServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.WriterFileServiceImpl;

public class Main {
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
        List<String> listFromFile = readerFileService.readFromFile();

        ActivitiesStrategy activitiesStrategy = new ActivitiesStrategyImpl(activitiesHandlerMap);

        FruitShopService fruitShopService = new FruitShopServiceImpl(activitiesStrategy);
        fruitShopService.convert(listFromFile);

        ReportService reportService = new ReportServiceImpl(fruitShopService);

        List<String> report = reportService.createReport();
        WriterFileService writerFileService = new WriterFileServiceImpl();
        writerFileService.writeToFile(report);
    }

}
