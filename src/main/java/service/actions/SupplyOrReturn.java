package service.actions;

import dao.FruitDao;
import model.Fruit;
import model.FruitDataDto;

public class SupplyOrReturn implements ActivityHandler {
    private FruitDao fruitDao;

    public SupplyOrReturn(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public boolean apply(FruitDataDto fruitDataDto) {
        Fruit fruit = new Fruit(fruitDataDto.getFruit());
        Integer newAmount = fruitDao.get(fruit).orElseThrow(()
                -> new RuntimeException("No such fruit in db")) + fruitDataDto.getAmount();
        fruitDao.add(fruit, newAmount);
        return true;
    }
}
