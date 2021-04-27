package core.basesyntax.store;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;

public class FruitServiceImpl implements FruitService {
    FruitDao fruitDao;

    public FruitServiceImpl() {
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public void createNewFruit(String name, long quantity) {
        fruitDao.add(new Fruit(name, quantity));
    }
}
