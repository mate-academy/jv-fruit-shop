import java.io.File;
import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;
import service.CsvFileReaderService;
import service.CsvFileWriterService;
import service.FileReaderService;
import service.FileWriterService;
import service.FruitShopService;
import service.FruitShopServiceImpl;
import service.TransactionStrategy;
import service.TransactionStrategyImpl;
import service.transaction.BalanceTransactionHandler;
import service.transaction.PurchaseTransactionHandler;
import service.transaction.ReturnTransactionHandler;
import service.transaction.SupplyTransactionHandler;
import service.transaction.TransactionHandler;

public class Main {
    public static final Map<FruitTransaction.Operation,
                        TransactionHandler> transactionHandlerMap = new HashMap<>();
    public static final File INPUT_FILE =
                            new File("src/main/resources/inputData.csv");
    public static final File REPORT_FILE =
                            new File("src/main/resources/reportFile.csv");

    public static void main(String[] args) {
        transactionHandlerMap.put(FruitTransaction.Operation.BALANCE,
                                    new BalanceTransactionHandler());
        transactionHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                                    new PurchaseTransactionHandler());
        transactionHandlerMap.put(FruitTransaction.Operation.RETURN,
                                    new ReturnTransactionHandler());
        transactionHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                                    new SupplyTransactionHandler());
        TransactionStrategy transactionStrategy =
                new TransactionStrategyImpl(transactionHandlerMap);
        FileReaderService csvFileReader = new CsvFileReaderService();
        FileWriterService csvFileWriter = new CsvFileWriterService();
        FruitShopService fruitShopService =
                new FruitShopServiceImpl(transactionStrategy,
                                        csvFileReader,
                                        csvFileWriter);
        fruitShopService.generateDailyReport(INPUT_FILE, REPORT_FILE);
    }
}
