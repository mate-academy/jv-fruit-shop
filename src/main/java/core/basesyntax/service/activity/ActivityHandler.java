package core.basesyntax.service.activity;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.database.FruitDto;

public interface ActivityHandler {
    FruitsDao fruitsDao = new FruitsDaoImpl();

    void doActivity(FruitDto fruitDto);
}
