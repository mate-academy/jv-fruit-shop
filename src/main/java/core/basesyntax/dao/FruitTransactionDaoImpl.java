package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class FruitTransactionDaoImpl implements FruitTransactionDao {
    @Override
    public FruitTransaction getFromStorage(FruitTransaction fruitTransaction) {
        for (FruitTransaction fruit : Storage.fruitTransactions) {
            if (fruit.getFruit().equals(fruitTransaction.getFruit())) {
                return fruit;
            }
        }
        return null;
    }

    @Override
    public void addToStorage(FruitTransaction fruitTransaction) {
        Storage.fruitTransactions.add(fruitTransaction);
    }
}
