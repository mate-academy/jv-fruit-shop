import dao.FruitTransactionDao;
import dao.FruitTransactionDaoImpl;
import db.Storage;
import db.StorageCsvImpl;
import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;
import service.ActivityStrategy;
import service.ActivityStrategyImpl;
import service.FruitTransactionService;
import service.FruitTransactionServiceImpl;
import service.ReportService;
import service.ReportServiceCsvImpl;
import service.ShopService;
import service.ShopServiceImpl;
import service.activity.ActivityHandler;
import service.activity.BalanceActivityHandler;
import service.activity.PurchaseActivityHandler;
import service.activity.ReturnActivityHandler;
import service.activity.SupplyActivityHandler;

public class Main {
    public static void main(String[] args) {
        // Map for ActivityStrategy
        Storage storage = new StorageCsvImpl();
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
        FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoImpl(storage);
        ReportService reportService =
                new ReportServiceCsvImpl(activityStrategy, fruitTransactionDao);
        ShopService shopService = new ShopServiceImpl(fruitTransactionDao, reportService);
        shopService.addTransaction(fruitTransactionService
                .createNewTransaction("b", "banana", 20));
        shopService.addTransaction(fruitTransactionService
                        .createNewTransaction("b", "pineapple", 40));
        shopService.addTransaction(fruitTransactionService
                        .createNewTransaction("b", "apple", 60));
        shopService.addTransaction(fruitTransactionService
                        .createNewTransaction("p", "apple", 20));
        shopService.addTransaction(fruitTransactionService
                        .createNewTransaction("p", "banana", 10));
        shopService.addTransaction(fruitTransactionService
                        .createNewTransaction("p", "pineapple", 30));
        shopService.addTransaction(fruitTransactionService
                        .createNewTransaction("s", "banana", 20));
        shopService.addTransaction(fruitTransactionService
                        .createNewTransaction("s", "pineapple", 30));
        shopService.addTransaction(fruitTransactionService
                        .createNewTransaction("s", "apple", 60));
        shopService.addTransaction(fruitTransactionService
                        .createNewTransaction("r", "banana", 10));
        shopService.addTransaction(fruitTransactionService
                        .createNewTransaction("r", "pineapple", 5));
        shopService.addTransaction(fruitTransactionService
                        .createNewTransaction("r", "apple", 6));
        shopService.getReport();
    }
}
