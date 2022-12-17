import dao.FruitStorageDao;
import dao.FruitStorageDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.ActivityStrategy;
import service.FruitTransactionParser;
import service.ReaderService;
import service.ReportService;
import service.ShopService;
import service.WriterService;
import service.activity.ActivityHandler;
import service.activity.BalanceActivityHandler;
import service.activity.PurchaseActivityHandler;
import service.activity.ReturnActivityHandler;
import service.activity.SupplyActivityHandler;
import service.impl.ActivityStrategyImpl;
import service.impl.FruitTransactionParserImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.ShopServiceImpl;
import service.impl.WriterServiceImpl;

public class Main {
    public static void main(String[] args) {
        // Paths to files
        final String dataPath = "src/main/resources/database.Csv";
        final String reportPath = "src/main/resources/report.Csv";
        // Map for ActivityStrategy
        FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();
        Map<FruitTransaction.Operation, ActivityHandler> operationActivityHandlerMap =
                new HashMap<>();
        operationActivityHandlerMap.put(
                FruitTransaction.Operation.BALANCE, new BalanceActivityHandler(fruitStorageDao));
        operationActivityHandlerMap.put(
                FruitTransaction.Operation.PURCHASE, new PurchaseActivityHandler(fruitStorageDao));
        operationActivityHandlerMap.put(
                FruitTransaction.Operation.SUPPLY, new SupplyActivityHandler(fruitStorageDao));
        operationActivityHandlerMap.put(
                FruitTransaction.Operation.RETURN, new ReturnActivityHandler(fruitStorageDao));
        ActivityStrategy activityStrategy = new ActivityStrategyImpl(operationActivityHandlerMap);
        ReaderService readerService = new ReaderServiceImpl();
        FruitTransactionParser fruitTransactionParser = new FruitTransactionParserImpl();
        ShopService shopService = new ShopServiceImpl(activityStrategy);
        ReportService reportService = new ReportServiceImpl();
        WriterService writerService = new WriterServiceImpl();
        List<String> dataFromFile = readerService.read(dataPath);
        List<FruitTransaction> transactions = fruitTransactionParser.parse(dataFromFile);
        shopService.processTransactions(transactions);
        String report = reportService.createReport(fruitStorageDao.getAll());
        writerService.write(report, reportPath);
    }
}
