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
        for (String[] strings : dividedData) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(fruitTransaction
                    .getOperationFromEnum(strings[OPERATION_INDEX]));
            fruitTransaction.setFruit(strings[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(strings[QUANTITY_INDEX]));
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
