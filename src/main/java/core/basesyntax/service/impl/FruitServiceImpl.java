package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.FruitService;

public class FruitServiceImpl implements FruitService {
    private final FruitDao fruitDao;

    public FruitServiceImpl() {
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public void createNewFruit(String fruitName, int quantity) {
        fruitDao.add(fruitName, quantity);
    }
}
