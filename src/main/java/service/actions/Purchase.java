package service.actions;

import dao.FruitDao;
import dao.FruitDaoImpl;
import model.Fruit;
import model.FruitDataDto;
import service.DataValidator;
import service.DataValidatorImpl;

public class Purchase implements ActivityHandler {
    private FruitDao fruitDao = new FruitDaoImpl();

    public Purchase(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public boolean apply(FruitDataDto fruitDataDto) {
        DataValidator dataValidator = new DataValidatorImpl();
        Fruit fruit = new Fruit(fruitDataDto.getFruit());
        Integer newAmount = fruitDao.get(fruit) - fruitDataDto.getAmount();
        dataValidator.validateAmount(newAmount);
        fruitDao.add(fruit, newAmount);
        return true;
    }
}
