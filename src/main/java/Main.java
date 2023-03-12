import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.Reader;
import service.ReaderImpl;
import service.TransactionGenerateReportService;
import service.TransactionGenerateReportServiceImpl;
import service.TransactionProcessDataService;
import service.TransactionProcessDataServiceImpl;
import service.Writer;
import service.WriterImpl;
import service.transaction.BalanceTransactionHandler;
import service.transaction.PurchaseTransactionHandler;
import service.transaction.ReturnTransactionHandler;
import service.transaction.SupplyTransactionHandler;
import service.transaction.TransactionHandler;

public class Main {
    public static void main(String[] args) {
        Reader reader = new ReaderImpl();
        List<String> fromFile = reader.readFromFile("src/main/java/db/source.csv");
        Map<FruitTransaction.Operation, TransactionHandler> transactionHandlerMap =
                new HashMap<>();
        transactionHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceTransactionHandler());
        transactionHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyTransactionHandler());
        transactionHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseTransactionHandler());
        transactionHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnTransactionHandler());
        TransactionProcessDataService transactionProcessDataService =
                new TransactionProcessDataServiceImpl(transactionHandlerMap);
        Map<String, Integer> fruitsCount =
                transactionProcessDataService.processData(fromFile);
        TransactionGenerateReportService transactionGenerateReportService
                = new TransactionGenerateReportServiceImpl();
        String report = transactionGenerateReportService.generateReport(fruitsCount);
        Writer writer = new WriterImpl();
        writer.writeToFile("src/main/java/db/target.csv", report);
    }
}
