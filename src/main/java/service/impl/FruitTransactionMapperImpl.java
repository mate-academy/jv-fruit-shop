package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import model.Operation;

public class FruitTransactionMapperImpl implements service.FruitTransactionMapper {
    private static final List<FruitTransaction> FRUIT_TRANSACTIONS = new ArrayList<>();

    public List<FruitTransaction> map(List<String> fruitTransactionsList) {
        for (String fruitTransaction : fruitTransactionsList) {
            FRUIT_TRANSACTIONS.add(mapToObject(fruitTransaction));
        }
        return FRUIT_TRANSACTIONS;
    }

    private FruitTransaction mapToObject(String dataLine) {
        String separator = ",";
        int indexOfOperation = 0;
        int indexOfFruit = 1;
        int indexOfQuantity = 2;
        String[] fruitTransaction = dataLine.split(separator);
        Operation operation = Operation.getByCode(fruitTransaction[indexOfOperation]);
        String fruit = fruitTransaction[indexOfFruit];
        int quantity = Integer.parseInt(fruitTransaction[indexOfQuantity]);
        return new FruitTransaction(operation, fruit, quantity);
    }
}
