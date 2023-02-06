package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final int OPERATION_TYPE = 0;
    private static final int TYPE_OF_FRUIT = 1;
    private static final int QUANTITY = 2;

    public List<FruitTransaction> getFruitTransaction(List<String> transactions) {

        List<FruitTransaction> fruitTransactionsList = new ArrayList<>();
        for (int i = 1; i < transactions.size(); i++) {
            String[] array = transactions.get(i).split(",");
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(
                    FruitTransaction.Operation.BALANCE.fromString(array[OPERATION_TYPE]));
            fruitTransaction.setFruit(array[TYPE_OF_FRUIT]);
            fruitTransaction.setQuantity(Integer.parseInt(array[QUANTITY]));
            fruitTransactionsList.add(fruitTransaction);
        }
        return fruitTransactionsList;
    }
}

