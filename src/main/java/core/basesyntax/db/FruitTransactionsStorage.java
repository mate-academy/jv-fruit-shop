package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class FruitTransactionsStorage implements Storage<FruitTransaction> {
    private static List<FruitTransaction> fruitTransactions;

    @Override
    public List<FruitTransaction> getStorage() {
        return fruitTransactions;
    }

    @Override
    public void setStorage(List<FruitTransaction> fruitTransactions) {
        FruitTransactionsStorage.fruitTransactions = fruitTransactions;
    }
}
