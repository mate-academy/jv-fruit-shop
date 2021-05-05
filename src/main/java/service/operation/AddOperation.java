package service.operation;

import dao.FruitsDao;
import model.Fruit;
import model.FruitRecordDto;

public class AddOperation implements Operation {
    private FruitsDao fruitsDao;

    public AddOperation(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = fruitsDao.getAmountByType(fruitRecordDto.getFruitType());
        int newAmount = fruitsDao.getAmount(fruit) + fruitRecordDto.getAmount();
        fruitsDao.update(fruit, newAmount);
    }
}
