import dao.Dao;
import dao.StorageDao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.file.CsvFileReader;
import service.file.CsvFileWriter;
import service.file.FileReader;
import service.file.FileWriter;
import service.report.Reporter;
import service.report.ResultReporter;
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
    private static final String RECORDS_FILE_PATH = "src\\main\\resources\\Records.csv";
    private static final String REPORT_FILE_PATH = "src\\main\\resources\\Report.csv";

    public static void main(String[] args) {
        Dao dao = new StorageDao();
        FileReader fileReader = new CsvFileReader();
        TransactionParser transactionParser = new CsvTransactionParser();
        TransactionExecutor transactionExecutor = new ProductTransactionExecutor(strategy(), dao);
        Reporter reporter = new ResultReporter(dao);
        FileWriter fileWriter = new CsvFileWriter();

        List<String> data = fileReader.read(RECORDS_FILE_PATH);
        List<FruitTransaction> fruitTransactions = transactionParser.parse(data);
        transactionExecutor.execute(fruitTransactions);
        List<String> report = reporter.generate();
        fileWriter.write(report, REPORT_FILE_PATH);
    }

    private static TransactionStrategy strategy() {
        Map<FruitTransaction.OperationType, TransactionHandler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.OperationType.BALANCE, new BalanceTransaction());
        handlers.put(FruitTransaction.OperationType.PURCHASE, new PurchaseTransaction());
        handlers.put(FruitTransaction.OperationType.SUPPLY, new SupplyTransaction());
        handlers.put(FruitTransaction.OperationType.RETURN, new ReturnTransaction());
        return new ProductTransactionStrategy(handlers);
    }
}
