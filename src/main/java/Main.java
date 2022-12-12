import dao.FruitTransactionDao;
import dao.FruitTransactionDaoImpl;
import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;
import service.ActivityStrategy;
import service.ActivityStrategyImpl;
import service.FruitTransactionService;
import service.FruitTransactionServiceImpl;
import service.ReaderService;
import service.ReaderServiceImpl;
import service.ReportService;
import service.ReportServiceImpl;
import service.ShopService;
import service.ShopServiceImpl;
import service.WriterService;
import service.WriterServiceImpl;
import service.activity.ActivityHandler;
import service.activity.BalanceActivityHandler;
import service.activity.PurchaseActivityHandler;
import service.activity.ReturnActivityHandler;
import service.activity.SupplyActivityHandler;

public class Main {
    public static void main(String[] args) {
        // Map for ActivityStrategy
        Map<FruitTransaction.Operation, ActivityHandler> operationActivityHandlerMap =
                new HashMap<>();
        operationActivityHandlerMap.put(
                FruitTransaction.Operation.BALANCE, new BalanceActivityHandler());
        operationActivityHandlerMap.put(
                FruitTransaction.Operation.PURCHASE, new PurchaseActivityHandler());
        operationActivityHandlerMap.put(
                FruitTransaction.Operation.SUPPLY, new SupplyActivityHandler());
        operationActivityHandlerMap.put(
                FruitTransaction.Operation.RETURN, new ReturnActivityHandler());
        ActivityStrategy activityStrategy =
                new ActivityStrategyImpl(operationActivityHandlerMap);
        FruitTransactionService fruitTransactionService =
                new FruitTransactionServiceImpl(activityStrategy);
        ReaderService readerService = new ReaderServiceImpl(fruitTransactionService);
        WriterService writerService = new WriterServiceImpl();
        FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoImpl();
        ReportService reportService = new ReportServiceImpl(activityStrategy);
        ShopService shopService = new ShopServiceImpl(fruitTransactionDao, readerService,
                writerService, reportService);
        shopService.addTransactions();
        shopService.createReport();
    }
}
