package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import model.Operation;
import service.TransactionMapper;

public class FruitTransactionMapper implements TransactionMapper {
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_QUANTITY = 2;
    private static final String SEPARATOR = ",";

    public List<FruitTransaction> map(List<String> fruitTransactionsList) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String fruitTransaction : fruitTransactionsList) {
            fruitTransactions.add(mapToObject(fruitTransaction));
        }
        return fruitTransactions;
    }

    private FruitTransaction mapToObject(String dataLine) {
        String[] fruitTransaction = dataLine.split(SEPARATOR);
        Operation operation = Operation.parse(fruitTransaction[INDEX_OF_OPERATION]);
        String fruit = fruitTransaction[INDEX_OF_FRUIT];
        int quantity = Integer.parseInt(fruitTransaction[INDEX_OF_QUANTITY]);
        return new FruitTransaction(operation, fruit, quantity);
    }
}
