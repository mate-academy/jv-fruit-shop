package core.basesyntax.service.activity;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public interface ActivityHandler {
    void operate(FruitTransaction fruitTransaction, FruitDao fruitDao);
}
