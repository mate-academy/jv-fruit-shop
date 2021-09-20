package core.basesyntax.service.activity;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;

public interface ActivityHandler {
    FruitsDao fruitsDao = new FruitsDaoImpl();

    boolean doActivity(String[] fruits);
}
