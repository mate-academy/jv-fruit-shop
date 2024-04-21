package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import model.Operation;

public class FruitTransactionMapperImpl implements service.FruitTransactionMapper {

    public List<FruitTransaction> map(List<String> fruitTransactionsList) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String fruitTransaction : fruitTransactionsList) {
            fruitTransactions.add(mapToObject(fruitTransaction));
        }
        return fruitTransactions;
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
