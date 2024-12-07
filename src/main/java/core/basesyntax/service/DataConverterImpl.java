package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int TYPE = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> input) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();

        for (String s : input) {
            String[] transaction = s.split(",");

            FruitTransaction fruitTransaction = new FruitTransaction();

            switch (transaction[TYPE]) {
                case "b" -> fruitTransaction.setOperation(FruitTransaction.Operation.BALANCE);
                case "s" -> fruitTransaction.setOperation(FruitTransaction.Operation.SUPPLY);
                case "p" -> fruitTransaction.setOperation(FruitTransaction.Operation.PURCHASE);
                case "r" -> fruitTransaction.setOperation(FruitTransaction.Operation.RETURN);
                default -> fruitTransaction.setOperation(FruitTransaction.Operation.NONE);
            }
            fruitTransaction.setFruit(transaction[FRUIT]);
            fruitTransaction.setQuantity(Integer.parseInt(transaction[QUANTITY]));

            fruitTransactionList.add(fruitTransaction);
        }

        return fruitTransactionList;
    }
}
