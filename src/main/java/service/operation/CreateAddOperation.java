package service.operation;

import dao.FruitsDao;
import model.Fruit;
import model.FruitRecordDto;

public class CreateAddOperation implements Operation {
    private FruitsDao fruitsDao;

    public CreateAddOperation(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public boolean apply(FruitRecordDto fruitRecordDto) {
        fruitsDao.add(new Fruit(fruitRecordDto.getFruitType()), fruitRecordDto.getAmount());
        return true;
    }
}
