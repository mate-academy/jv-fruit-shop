package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;

public class FruitServiceImpl implements FruitService {
    private final FruitDao fruitBoxDao;

    public FruitServiceImpl(FruitDao fruitBoxDao) {
        this.fruitBoxDao = fruitBoxDao;
    }

    public void createFruitBox(String name) {
        Fruit fruitBox = new Fruit(name);
        fruitBoxDao.add(fruitBox);
    }
}
