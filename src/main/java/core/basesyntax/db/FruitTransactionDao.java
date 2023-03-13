package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface FruitTransactionDao {

    void saveAll(List<FruitTransaction> fruitTransactions);

    List<FruitTransaction> getAll();

    List<Fruit> process(); ///List<FruitTransaction> fruitTransactionList

}
