package service.operation;

import dao.FruitsDao;
import exception.NoFruitsException;
import model.Fruit;
import model.FruitRecordDto;

public class AddOperation implements Operation {
    private FruitsDao fruitsDao;

    public AddOperation(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public boolean apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = fruitsDao.get(fruitRecordDto.getFruitType());
        int newAmount = fruitsDao.getAmount(fruit) + fruitRecordDto.getAmount();
        try {
            fruitsDao.update(fruit, newAmount);
        } catch (NoFruitsException e) {
            return false;
        }
        return true;
    }
}
