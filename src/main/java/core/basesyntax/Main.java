package core.basesyntax;

import dao.StorageDao;
import dao.StorageDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Transaction;
import service.CsvFileServiceImpl;
import service.FileService;
import service.ReportGenerator;
import service.ReportGeneratorImpl;
import service.TransactionParser;
import service.TransactionParserImpl;
import service.operation.BalanceOperation;
import service.operation.OperationHandler;
import service.operation.OperationStrategy;
import service.operation.OperationStrategyImpl;
import service.operation.PurchaseOperation;
import service.operation.ReturnOperation;
import service.operation.SupplyOperation;

public class Main {
    public static void main(String[] args) {
        FileService fileService = new CsvFileServiceImpl();
        TransactionParser parser = new TransactionParserImpl();

        String sourceFile = "src/input.csv";
        List<String> stringData = fileService.readFromFile(sourceFile);

        StorageDao storageDao = new StorageDaoImpl();
        Map<Transaction.Operation, OperationHandler> handlersStrategy = new HashMap<>();
        handlersStrategy.put(Transaction.Operation.BALANCE, new BalanceOperation(storageDao));
        handlersStrategy.put(Transaction.Operation.RETURN, new ReturnOperation(storageDao));
        handlersStrategy.put(Transaction.Operation.SUPPLY, new SupplyOperation(storageDao));
        handlersStrategy.put(Transaction.Operation.PURCHASE, new PurchaseOperation(storageDao));

        List<Transaction> transactions = parser.parse(stringData);
        OperationStrategy strategy = new OperationStrategyImpl(handlersStrategy);
        for (Transaction transaction: transactions) {
            OperationHandler handler = strategy.getOperation(transaction);
            handler.proceed(transaction);
        }

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String data = reportGenerator.generate(storageDao.getAll());
        String destinationFile = "src/report.csv";
        fileService.writeToFile(data, destinationFile);
    }
}
