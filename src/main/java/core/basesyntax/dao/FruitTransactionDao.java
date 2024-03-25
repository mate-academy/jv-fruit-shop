package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class FruitTransactionDao implements IFruitTransactionDao {
    @Override
    public void add(FruitTransaction fruitTransaction) {
        Storage.fruitTransactions.add(fruitTransaction);
    }

    @Override
    public FruitTransaction getByIndex(int index) {
        if (index >= getLength()) {
            throw new IndexOutOfBoundsException();
        }
        return Storage.fruitTransactions.get(index);
    }

    @Override
    public int getLength() {
        return Storage.fruitTransactions.size();
    }
}
