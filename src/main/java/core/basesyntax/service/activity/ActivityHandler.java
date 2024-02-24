package core.basesyntax.service.activity;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;

public interface ActivityHandler {
    FruitDao fruitDao = new FruitDaoImpl();

    void operate(FruitTransaction fruitTransaction);
}
