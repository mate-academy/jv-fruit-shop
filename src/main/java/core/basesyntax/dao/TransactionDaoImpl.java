package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class TransactionDaoImpl implements TransactionDao {
    @Override
    public void addTransaction(FruitTransaction transaction) {
        Storage.fruitTransactions.add(transaction);
    }

    @Override
    public void addFruit(Fruit fruit) {
        Storage.fruits.add(fruit);
    }

    @Override
    public Fruit getFruit(String fruitType) {
        return Storage.fruits.stream()
                .filter(fruit -> fruit.getFruitType().equals(fruitType))
                .findFirst()
                .get();
    }
}
