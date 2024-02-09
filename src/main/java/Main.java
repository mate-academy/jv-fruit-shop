import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.Parser;
import service.Reader;
import service.Writer;
import service.impl.CsvFruitReader;
import service.impl.FruitCsvWriter;
import service.impl.FruitTransactionParser;
import strategy.FruitStorageHandler;
import strategy.FruitTransactionStrategy;
import strategy.StorageHandler;
import strategy.TransactionStrategy;
import strategy.operation.FruitBalanceOperation;
import strategy.operation.FruitPurchaseOperation;
import strategy.operation.FruitReturnOperation;
import strategy.operation.FruitSupplyOperation;
import strategy.operation.OperationHandler;

public class Main {
    public static void main(String[] args) {

        Map<FruitTransaction.Operation,
                OperationHandler<String, Integer>> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new FruitBalanceOperation());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new FruitPurchaseOperation());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new FruitSupplyOperation());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new FruitReturnOperation());

        Reader reader = new CsvFruitReader();
        List<String> readFile = reader.read();

        Parser parser = new FruitTransactionParser();
        List<FruitTransaction> transactions = parser.parse(readFile);

        TransactionStrategy makeTransactions = new FruitTransactionStrategy(operationHandlerMap);
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = makeTransactions.get(transaction.getOperation());
            handler.doOperation(transaction.getFruit(), transaction.getQuantity());
        }

        Writer writer = new FruitCsvWriter();
        StorageHandler<String,Integer> storageHandler = new FruitStorageHandler();
        writer.write(storageHandler.createReport());
    }
}
