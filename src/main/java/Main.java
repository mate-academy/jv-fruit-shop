import db.FruitStorage;
import db.FruitStorageDao;
import db.StorageDao;
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
    private static final String INPUT_FILE_NAME = "Fruits.csv";
    private static final String REPORT_FILE_NAME = "FruitReport.csv";

    public static void main(String[] args) {
        FruitStorage fruitStorage = new FruitStorage();
        StorageDao<String,Integer> storageHandler = new FruitStorageDao(fruitStorage);

        Map<FruitTransaction.Operation,
                OperationHandler<String, Integer>> operationHandlerMap = Map.of(
                        FruitTransaction.Operation.BALANCE,
                            new FruitBalanceOperation(storageHandler),
                        FruitTransaction.Operation.PURCHASE,
                            new FruitPurchaseOperation(storageHandler),
                        FruitTransaction.Operation.SUPPLY,
                            new FruitSupplyOperation(storageHandler),
                        FruitTransaction.Operation.RETURN,
                            new FruitReturnOperation(storageHandler)
                );

        Reader reader = new CsvFruitReader();
        List<String> readFile = reader.read(INPUT_FILE_NAME);

        Parser parser = new FruitTransactionParser();
        List<FruitTransaction> transactions = parser.parse(readFile);

        TransactionStrategy makeTransactions = new FruitTransactionStrategy(operationHandlerMap);
        Performer performer = new FruitOperationPerformer(makeTransactions);
        performer.performProcesses(transactions);

        Reporter reporter = new FruitReporter(fruitStorage);
        Writer writer = new FruitCsvWriter();
        writer.write(reporter.getReport(), REPORT_FILE_NAME);
    }
}
