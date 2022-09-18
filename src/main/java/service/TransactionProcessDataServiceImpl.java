package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.transaction.TransactionHandler;
import service.transaction.TransactionStrategy;

public class TransactionProcessDataServiceImpl implements TransactionProcessDataService {
    private static final String SIGN_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final Map<FruitTransaction.Operation, TransactionHandler> transactionHandlerMap;

    public TransactionProcessDataServiceImpl(Map<FruitTransaction.Operation,
            TransactionHandler> transactionHandlerMap) {
        this.transactionHandlerMap = transactionHandlerMap;
    }

    @Override
    public Map<String, Integer> processData(List<String> data) {
        List<FruitTransaction> fruitTransactions = parseDataToTransactions(data);
        return executeTransactions(fruitTransactions);
    }

    private Map<String, Integer> executeTransactions(List<FruitTransaction> transactions) {
        Map<String, Integer> result = new HashMap<>();
        for (FruitTransaction transaction : transactions) {
            TransactionStrategy transactionStrategy =
                    new TransactionStrategy(transactionHandlerMap);
            TransactionHandler transactionHandler =
                    transactionStrategy.get(transaction.getOperation());
            int transactionResult = transactionHandler
                    .getTransactionResult(result.getOrDefault(transaction.getFruit(), 0),
                            transaction.getQuantity());
            result.put(transaction.getFruit(), transactionResult);
        }
        return result;
    }

    private List<FruitTransaction> parseDataToTransactions(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            FruitTransaction fruitTransaction = createTransaction(data.get(i));
            transactions.add(fruitTransaction);
        }
        return transactions;
    }

    private FruitTransaction createTransaction(String line) {
        String[] splitedLine = line.split(SIGN_SEPARATOR);
        FruitTransaction fruitTransaction = new FruitTransaction();
        FruitTransaction.Operation operation =
                fruitTransaction.getOperationByLetter(splitedLine[OPERATION_INDEX]);
        fruitTransaction.setOperation(operation);
        fruitTransaction.setFruit(splitedLine[FRUIT_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(splitedLine[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
