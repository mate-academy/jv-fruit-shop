package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import operation.OperationHandler;
import operation.OperationStrategy;
import service.TransactionParser;

public class CsvTransactionParser implements TransactionParser {
    private final OperationStrategy operationStrategy;

    public CsvTransactionParser(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public List<FruitTransaction> parse(List<String> rowsList) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String row : rowsList) {
            String[] values = row.split(",");
            OperationHandler activity = operationStrategy.get(values[0]);
            String fruit = values[1];
            int amount = Integer.parseInt(values[2]);

            fruitTransactions.add(new FruitTransaction(activity, fruit, amount));
        }

        return fruitTransactions;
    }
}
