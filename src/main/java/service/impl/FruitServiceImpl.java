package service.impl;

import dao.FruitDao;
import dao.FruitDaoImpl;
import model.Fruit;
import service.FruitService;

public class FruitServiceImpl implements FruitService {
    private FruitDao fruitDao;

    public FruitServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void addNewFruit(String fruitName) {
        Fruit fruit = new Fruit();
        fruit.setName(fruitName);
        fruitDao.add(fruit);
    }
}
