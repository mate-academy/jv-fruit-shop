package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String SPLITERATOR = ",";
    private static final int TYPE = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> input) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String line : input) {
            String[] transaction = line.split(SPLITERATOR);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(OperationStrategyImpl.getOperation(transaction[TYPE]));
            fruitTransaction.setFruit(transaction[FRUIT]);
            fruitTransaction.setQuantity(Integer.parseInt(transaction[QUANTITY]));
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }
}
