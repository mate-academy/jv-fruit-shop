package service.actions;

import dao.FruitDao;
import model.Fruit;
import model.FruitDataDto;

public class Balance implements ActivityHandler {
    private FruitDao fruitDao;

    public Balance(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public boolean apply(FruitDataDto fruitDataDto) {
        fruitDao.add(new Fruit(fruitDataDto.getFruit()), fruitDataDto.getAmount());
        return true;
    }
}
