package core.basesyntax.service;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.Fruit;
import java.util.List;

public class StoreServiceImpl implements StoreService {
    private FruitsDao fruitsDao;

    public StoreServiceImpl(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public List<Fruit> setFruits(FruitService fruitService) {
        return fruitService.getFruitsBalance(fruitsDao.getData());
    }
}
