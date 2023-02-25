package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;

public interface FruitService {
    FruitDao FRUIT_DAO = new FruitDaoImpl();
    void moveFruit(String fruit, Integer amount);
}
