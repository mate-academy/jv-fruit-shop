import db.FruitStorage;
import db.FruitStorageDao;
import db.StorageDao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.Parser;
import service.Performer;
import service.Reader;
import service.Reporter;
import service.Writer;
import service.impl.CsvFruitReader;
import service.impl.FruitCsvWriter;
import service.impl.FruitOperationPerformer;
import service.impl.FruitReporter;
import service.impl.FruitTransactionParser;
import strategy.FruitTransactionStrategy;
import strategy.TransactionStrategy;
import strategy.operation.FruitBalanceOperation;
import strategy.operation.FruitPurchaseOperation;
import strategy.operation.FruitReturnOperation;
import strategy.operation.FruitSupplyOperation;
import strategy.operation.OperationHandler;

public class Main {
    public static void main(String[] args) {
        String nameReadingFile = "Fruits.csv";
        FruitStorage fruitStorage = new FruitStorage();
        StorageDao<String,Integer> storageHandler = new FruitStorageDao(fruitStorage);

        Map<FruitTransaction.Operation,
                OperationHandler<String, Integer>> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new FruitBalanceOperation(storageHandler));
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new FruitPurchaseOperation(storageHandler));
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new FruitSupplyOperation(storageHandler));
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new FruitReturnOperation(storageHandler));

        Reader reader = new CsvFruitReader();
        List<String> readFile = reader.read(nameReadingFile);

        Parser parser = new FruitTransactionParser();
        List<FruitTransaction> transactions = parser.parse(readFile);

        TransactionStrategy makeTransactions = new FruitTransactionStrategy(operationHandlerMap);
        Performer performer = new FruitOperationPerformer(makeTransactions);
        performer.performProcesses(transactions);

        Reporter reporter = new FruitReporter(fruitStorage);
        Writer writer = new FruitCsvWriter();
        writer.write(reporter.getReport(), "FruitReport.csv");
    }
}
