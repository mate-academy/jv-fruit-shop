package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Transaction;
import java.util.ArrayList;
import java.util.List;

public class TransactionImpl implements Transaction {
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int AMOUNT_INDEX = 2;
    public static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parseTransaction(List<String> transaction) {
        List<FruitTransaction> newTransaction = new ArrayList<>();
        for (String string : transaction) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] stringArray = string.split(SEPARATOR);
            fruitTransaction.setOperation(FruitTransaction.Operation
                    .getOperationByCode(stringArray[OPERATION_INDEX]));
            fruitTransaction.setFruit(stringArray[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(stringArray[AMOUNT_INDEX]));
            newTransaction.add(fruitTransaction);
        }
        return newTransaction;
    }
}
