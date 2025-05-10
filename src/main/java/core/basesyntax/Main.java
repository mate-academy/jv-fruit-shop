package core.basesyntax;

import dao.StorageDao;
import dao.StorageDaoImpl;
import java.util.List;
import java.util.Map;
import model.Transaction;
import service.CsvFileServiceImpl;
import service.FileService;
import service.ReportGenerator;
import service.ReportGeneratorImpl;
import service.TransactionParser;
import service.TransactionParserImpl;
import service.TransactionService;
import service.TransactionServiceImpl;
import service.operation.BalanceOperation;
import service.operation.OperationHandler;
import service.operation.OperationStrategyImpl;
import service.operation.PurchaseOperation;
import service.operation.ReturnOperation;
import service.operation.SupplyOperation;

public class Main {
    public static final String SOURCE_FILE = "src/main/resources/input.csv";
    public static final String DESTINATION_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileService fileService = new CsvFileServiceImpl();
        TransactionParser parser = new TransactionParserImpl();
        List<String> stringData = fileService.readFromFile(SOURCE_FILE);
        StorageDao storageDao = new StorageDaoImpl();
        Map<Transaction.Operation, OperationHandler> handlersStrategy = Map.of(
                Transaction.Operation.BALANCE, new BalanceOperation(storageDao),
                Transaction.Operation.RETURN, new ReturnOperation(storageDao),
                Transaction.Operation.SUPPLY, new SupplyOperation(storageDao),
                Transaction.Operation.PURCHASE, new PurchaseOperation(storageDao));
        List<Transaction> transactions = parser.parse(stringData);
        TransactionService transactionService =
                new TransactionServiceImpl(new OperationStrategyImpl(handlersStrategy));
        transactionService.processTransactions(transactions);
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String data = reportGenerator.generate(storageDao.getAll());
        fileService.writeToFile(data, DESTINATION_FILE);
    }
}
