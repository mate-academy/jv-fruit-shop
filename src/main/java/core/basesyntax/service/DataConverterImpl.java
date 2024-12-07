package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private final static int TYPE = 0;
    private final static int FRUIT = 1;
    private final static int QUANTITY = 2;

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
            }
            fruitTransaction.setFruit(transaction[FRUIT]);
            fruitTransaction.setQuantity(Integer.parseInt(transaction[QUANTITY]));

            fruitTransactionList.add(fruitTransaction);
        }

        return fruitTransactionList;
    }
}
