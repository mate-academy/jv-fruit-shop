import db.Storage;
import model.FruitTransaction;
import service.CsvFileReaderService;
import service.FileReaderService;
import service.ReportService;
import service.ReportServiceImpl;
import service.TransactionStrategy;
import service.TransactionStrategyImpl;
import service.transaction.BalanceTransactionHandler;
import service.transaction.PurchaseTransactionHandler;
import service.transaction.ReturnTransactionHandler;
import service.transaction.SupplyTransactionHandler;
import service.transaction.TransactionHandler;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<FruitTransaction.Operation,
                        TransactionHandler> transactionHandlerMap = new HashMap<>();
    public static TransactionHandler balanceTransactionHandler =
                                        new BalanceTransactionHandler();
    public static TransactionHandler purchaseTransactionHandler =
                                        new PurchaseTransactionHandler();
    public static TransactionHandler returnTransactionHandler =
                                        new ReturnTransactionHandler();
    public static TransactionHandler supplyTransactionHandler =
                                        new SupplyTransactionHandler();

    public static void main(String[] args) {
        String pathToInputDataFile = "src/main/resources/inputData.csv";
        File inputData = new File(pathToInputDataFile);
        FileReaderService csvFileReader = new CsvFileReaderService();
        List<FruitTransaction> fruitTransactions = csvFileReader.getTransactionsFromFile(inputData);
        transactionHandlerMap.put(FruitTransaction.Operation.BALANCE, balanceTransactionHandler);
        transactionHandlerMap.put(FruitTransaction.Operation.PURCHASE, purchaseTransactionHandler);
        transactionHandlerMap.put(FruitTransaction.Operation.RETURN, returnTransactionHandler);
        transactionHandlerMap.put(FruitTransaction.Operation.SUPPLY, supplyTransactionHandler);
        TransactionStrategy transactionStrategy = new TransactionStrategyImpl(transactionHandlerMap);
        ReportService reportService = new ReportServiceImpl(transactionStrategy);
        reportService.createReport(fruitTransactions);
    }
}
