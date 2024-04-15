package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import model.Operation;

public class FruitTransactionMapperImpl implements service.FruitTransactionMapper {
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_QUANTITY = 2;
    private static final String SEPARATOR = ",";
    private static final List<FruitTransaction> FRUIT_TRANSACTIONS = new ArrayList<>();

    public List<FruitTransaction> map(List<String> fruitTransactionsList) {
        for (String fruitTransaction : fruitTransactionsList) {
            FRUIT_TRANSACTIONS.add(mapToObject(fruitTransaction));
        }
        return FRUIT_TRANSACTIONS;
    }

    private FruitTransaction mapToObject(String dataLine) {
        String[] fruitTransaction = dataLine.split(SEPARATOR);
        Operation operation = Operation.parse(fruitTransaction[INDEX_OF_OPERATION]);
        String fruit = fruitTransaction[INDEX_OF_FRUIT];
        int quantity = Integer.parseInt(fruitTransaction[INDEX_OF_QUANTITY]);
        return new FruitTransaction(operation, fruit, quantity);
    }
}
