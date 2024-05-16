package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(FruitTransaction fruitTransaction) {
        Storage.fruits.add(fruitTransaction);
        Storage.fruitNames.add(fruitTransaction.getFruit());
    }

    @Override
    public List<FruitTransaction> getFruitTransactionsByFruit(String fruit) {
        return Storage.fruits.stream()
                .filter(f -> f.getFruit().equals(fruit))
                .toList();
    }
}
