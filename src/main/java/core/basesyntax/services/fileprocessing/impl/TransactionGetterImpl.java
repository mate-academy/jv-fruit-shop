package core.basesyntax.services.fileprocessing.impl;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.fileprocessing.TransactionGetter;
import java.util.ArrayList;
import java.util.List;

public class TransactionGetterImpl implements TransactionGetter {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> getTransactionsData(List<String[]> dividedData) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        setTransactionsValues(fruitTransactions, dividedData);
        return fruitTransactions;
    }

    private void setTransactionsValues(List<FruitTransaction> fruitTransactions,
                                       List<String[]> dividedData) {
        for (String[] strings : dividedData) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            try {
                fruitTransaction.setOperation(
                        FruitTransaction.Operation.getOperationFromCode(strings[OPERATION_INDEX]));
            } catch (IllegalArgumentException iae) {
                throw new RuntimeException(
                        "Can't handle operation " + strings[OPERATION_INDEX]);
            }
            fruitTransaction.setFruit(strings[FRUIT_INDEX]);
            try {
                fruitTransaction.setQuantity(Integer.parseInt(strings[QUANTITY_INDEX]));
            } catch (NumberFormatException nfe) {
                throw new RuntimeException("Can't parse integer for argument "
                        + strings[QUANTITY_INDEX]);
            }
            fruitTransactions.add(fruitTransaction);
        }
    }
}
