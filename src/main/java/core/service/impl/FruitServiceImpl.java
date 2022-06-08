package core.service.impl;

import core.dao.FruitDao;
import core.service.FruitService;
import java.util.Map;

public class FruitServiceImpl implements FruitService {

    private final FruitDao fruitDao;

    public FruitServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void update(String fruitName, int quantity) {
        fruitDao.update(fruitName, quantity);
    }

    @Override
    public int get(String fruitName) {
        return fruitDao.get(fruitName);
    }

    @Override
    public Map<String, Integer> getAll() {
        return fruitDao.getAll();
    }
}
