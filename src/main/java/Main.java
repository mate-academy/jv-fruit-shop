
import dao.StorageDao;
import dao.impl.StorageDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.FileReaderService;
import service.FileWriterService;
import service.ReportService;
import service.TransactionService;
import sevice.impl.FileReader;
import sevice.impl.FileWriter;
import sevice.impl.ReportCreator;
import sevice.impl.TransactionServiceImpl;
import strategy.OperationStrategy;
import strategy.TransactionStrategy;
import strategy.strategyimpl.BalanceTransaction;
import strategy.strategyimpl.PurchaseTransaction;
import strategy.strategyimpl.ReturnTransaction;
import strategy.strategyimpl.SupplyTransaction;

public class Main {
    private static final String DATA_FILE = "src/main/resources/dataBase.csv";
    private static final String RESULT_FILE = "src/main/resources/report.csv";
    private static final String SPLITTER = ",";
    private static final String BALANCE = "b";
    private static final String SUPPLY = "s";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        Map<String, TransactionStrategy> strategyMap = new HashMap<>();
        strategyMap.put(BALANCE, new BalanceTransaction(storageDao));
        strategyMap.put(SUPPLY, new SupplyTransaction(storageDao));
        strategyMap.put(PURCHASE, new PurchaseTransaction(storageDao));
        strategyMap.put(RETURN, new ReturnTransaction(storageDao));
        FileReaderService reader = new FileReader();
        List<String> transaction = reader.readFromFile(DATA_FILE);
        OperationStrategy operationStrategy = new OperationStrategy(strategyMap);
        TransactionService transactionsToFile =
                new TransactionServiceImpl(SPLITTER, operationStrategy);
        transactionsToFile.transactionToDataBase(transaction, strategyMap);
        ReportService reportCreator = new ReportCreator(storageDao);
        List<String> report = reportCreator.createReport();
        FileWriterService writer = new FileWriter();
        writer.writeToFile(RESULT_FILE, report);
    }
}
