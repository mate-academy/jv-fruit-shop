package core.basesyntax.services.fileprocessing.impl;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.fileprocessing.TransactionGetter;
import java.util.ArrayList;
import java.util.List;

public class TransactionGetterImpl implements TransactionGetter {
    @Override
    public List<FruitTransaction> getTransactionsData(List<String[]> dividedData) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String[] strings : dividedData) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(fruitTransaction.getOperationFromEnum(strings[0]));
            fruitTransaction.setFruit(strings[1]);
            fruitTransaction.setQuantity(Integer.parseInt(strings[2]));
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
