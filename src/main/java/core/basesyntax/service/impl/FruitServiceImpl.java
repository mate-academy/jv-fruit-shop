package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.FruitService;

public class FruitServiceImpl implements FruitService {
    private final FruitDao fruitDao;

    public FruitServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void update(String fruitName, Integer amount) {
        fruitDao.update(fruitName, amount);
    }

    @Override
    public Integer getQuantity(String fruitName) {
        return fruitDao.getQuantity(fruitName);
    }
}
