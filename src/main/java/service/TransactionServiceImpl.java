package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.transaction.TransactionHandler;
import service.transaction.TransactionStrategy;
import service.transaction.TransactionStrategyImpl;

public class TransactionServiceImpl implements TransactionService {
    private static final String SIGN_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final List<FruitTransaction> transactions = new ArrayList<>();
    private final Map<String, Integer> storage = new HashMap<>();
    private final Map<FruitTransaction.Operation, TransactionHandler> transactionHandlerMap;

    public TransactionServiceImpl(Map<FruitTransaction.Operation,
            TransactionHandler> transactionHandlerMap) {
        this.transactionHandlerMap = transactionHandlerMap;
    }

    @Override
    public void processData(List<String> data) {
        parseDataToTransactions(data);
        executeTransactions();
    }

    @Override
    public String generateReport() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> line : storage.entrySet()) {
            stringBuilder.append(line.getKey())
                    .append(",")
                    .append(line.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    private void executeTransactions() {
        for (FruitTransaction transaction : transactions) {
            TransactionStrategy transactionStrategy =
                    new TransactionStrategyImpl(transactionHandlerMap);
            TransactionHandler transactionHandler =
                    transactionStrategy.get(transaction.getOperation());
            int transactionResult = transactionHandler
                    .getTransactionResult(storage.getOrDefault(transaction.getFruit(), 0),
                            transaction.getQuantity());
            storage.put(transaction.getFruit(), transactionResult);
        }
    }

    private void parseDataToTransactions(List<String> data) {
        for (String line : data) {
            FruitTransaction fruitTransaction = createTransaction(line);
            transactions.add(fruitTransaction);
        }
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
