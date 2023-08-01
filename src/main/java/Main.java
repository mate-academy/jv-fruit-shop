import dao.DbDao;
import dao.StorageDao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Transaction;
import service.file.CsvFileReader;
import service.file.CsvFileWriter;
import service.file.FileReader;
import service.file.FileWriter;
import service.report.DbReporter;
import service.report.Reporter;
import service.transaction.CsvTransactionParser;
import service.transaction.ProductTransactionExecutor;
import service.transaction.TransactionExecutor;
import service.transaction.TransactionParser;
import service.transaction.strategy.ProductTransactionStrategy;
import service.transaction.strategy.TransactionStrategy;
import service.transaction.strategy.type.BalanceTransaction;
import service.transaction.strategy.type.PurchaseTransaction;
import service.transaction.strategy.type.ReturnTransaction;
import service.transaction.strategy.type.SupplyTransaction;
import service.transaction.strategy.type.TransactionHandler;

public class Main {
    private static String RECORDS_FILE_NAME = "Records.csv";

    public static void main(String[] args) {
        DbDao dbDao = new StorageDao();
        FileReader fileReader = new CsvFileReader();
        TransactionParser transactionParser = new CsvTransactionParser();
        TransactionExecutor transactionExecutor = new ProductTransactionExecutor(strategy(), dbDao);
        Reporter reporter = new DbReporter(dbDao);
        FileWriter fileWriter = new CsvFileWriter();

        List<String> data = fileReader.read(RECORDS_FILE_NAME);
        List<Transaction> transactions = transactionParser.parse(data);
        transactionExecutor.execute(transactions);
        List<String> report = reporter.generate();
        fileWriter.write(report);
    }

    private static TransactionStrategy strategy() {
        Map<Transaction.Type, TransactionHandler> handlers = new HashMap<>();
        handlers.put(Transaction.Type.BALANCE, new BalanceTransaction());
        handlers.put(Transaction.Type.PURCHASE, new PurchaseTransaction());
        handlers.put(Transaction.Type.SUPPLY, new SupplyTransaction());
        handlers.put(Transaction.Type.RETURN, new ReturnTransaction());
        TransactionStrategy transactionStrategy = new ProductTransactionStrategy(handlers);
        return transactionStrategy;
    }
}
