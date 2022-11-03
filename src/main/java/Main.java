
import dao.StorageDao;
import dao.impl.StorageDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.CsvReaderService;
import service.CsvWriterService;
import service.ReportCreateService;
import service.TransactionToDataBase;
import sevice.impl.CsvReader;
import sevice.impl.CsvWriter;
import sevice.impl.ReportCreator;
import sevice.impl.TransactionToDataBaseImpl;
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
        CsvReaderService reader = new CsvReader();
        List<String> transaction = reader.readFromFile(DATA_FILE);
        TransactionToDataBase transactionsToFile = new TransactionToDataBaseImpl(SPLITTER);
        transactionsToFile.transactionToDataBase(transaction, strategyMap);
        ReportCreateService reportCreator = new ReportCreator(storageDao);
        List<String> report = reportCreator.createReport();
        CsvWriterService writer = new CsvWriter();
        writer.writeToFile(RESULT_FILE, report);
    }
}
