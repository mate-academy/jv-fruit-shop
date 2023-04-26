package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class FruitTransactionDaoIml implements FruitTransactionDao {
    @Override
    public void add(FruitTransaction fruitTransaction) {
        Storage.fruits.add(fruitTransaction);
    }

    @Override
    public FruitTransaction get(String fruitName) {
        return Storage.fruits.stream()
                .filter(f -> f.getFruit().equals(fruitName))
                .findFirst().get();
    }

    @Override
    public List<FruitTransaction> getAllListDb() {
        return Storage.fruits;
    }

    @Override
    public void update(FruitTransaction fruitTransaction) {
        FruitTransaction ftFromDb = get(fruitTransaction.getFruit());
        Storage.fruits.remove(ftFromDb);
        add(fruitTransaction);
    }
}
