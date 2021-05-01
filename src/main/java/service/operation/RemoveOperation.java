package service.operation;

import dao.FruitsDao;
import exception.InvalidInputException;
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
        if (newAmount < 0) {
            throw new InvalidInputException("there are not enough "
                    + fruitRecordDto.getFruitType()
                    + " in the store");
        }
        try {
            fruitsDao.update(fruit, newAmount);
        } catch (InvalidInputException e) {
            return false;
        }
        return true;
    }
}
