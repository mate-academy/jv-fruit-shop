package service.actions;

import dao.FruitDao;
import dao.FruitDaoImpl;
import model.Fruit;
import model.FruitDataDto;

public class Return implements ActivityHandler {
    private FruitDao fruitDao = new FruitDaoImpl();

    public Return(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public boolean apply(FruitDataDto fruitDataDto) {
        Fruit fruit = new Fruit(fruitDataDto.getFruit());
        Integer newAmount = fruitDao.get(fruit) + fruitDataDto.getAmount();
        fruitDao.add(fruit, newAmount);
        return true;
    }
}
