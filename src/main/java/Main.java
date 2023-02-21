import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.CsvFileReaderService;
import service.CsvFileWriterService;
import service.FileReaderService;
import service.FileWriterService;
import service.ReportService;
import service.ReportServiceImpl;
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
    public static final TransactionHandler balanceTransactionHandler =
                                        new BalanceTransactionHandler();
    public static final TransactionHandler purchaseTransactionHandler =
                                        new PurchaseTransactionHandler();
    public static final TransactionHandler returnTransactionHandler =
                                        new ReturnTransactionHandler();
    public static final TransactionHandler supplyTransactionHandler =
                                        new SupplyTransactionHandler();

    public static void main(String[] args) {
        transactionHandlerMap.put(FruitTransaction.Operation.BALANCE, balanceTransactionHandler);
        transactionHandlerMap.put(FruitTransaction.Operation.PURCHASE, purchaseTransactionHandler);
        transactionHandlerMap.put(FruitTransaction.Operation.RETURN, returnTransactionHandler);
        transactionHandlerMap.put(FruitTransaction.Operation.SUPPLY, supplyTransactionHandler);
        String pathToInputDataFile = "src/main/resources/inputData.csv";
        File inputData = new File(pathToInputDataFile);
        FileReaderService csvFileReader = new CsvFileReaderService();
        List<FruitTransaction> fruitTransactions = csvFileReader.getTransactionsFromFile(inputData);
        TransactionStrategy transactionStrategy =
                            new TransactionStrategyImpl(transactionHandlerMap);
        ReportService reportService = new ReportServiceImpl(transactionStrategy);
        List<String> report = reportService.createReport(fruitTransactions);
        String pathToReportFile = "src/main/resources/reportFile.csv";
        File reportFile = new File(pathToReportFile);
        FileWriterService fileWriterService = new CsvFileWriterService();
        fileWriterService.saveToFile(reportFile, report);
        csvFileReader.readFile(reportFile);
    }
}
