package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public interface TransactionStrategy {
    FruitDao fruitDao = new FruitDao();

    void processData(FruitTransaction transaction);
}
