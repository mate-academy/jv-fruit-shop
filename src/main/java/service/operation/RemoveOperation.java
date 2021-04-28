package service.operation;

import dao.FruitsDao;
import model.Fruit;
import model.FruitRecordDto;

public class RemoveOperation implements Operation {
    private FruitsDao fruitsDao;

    public RemoveOperation(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public boolean apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = fruitsDao.get(fruitRecordDto.getFruitType());
        int newAmount = fruitsDao.getAmount(fruit) - fruitRecordDto.getAmount();
        fruitsDao.update(fruit, newAmount);
        return true;
    }
}
