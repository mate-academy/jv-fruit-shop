package service.actions;

import dao.FruitDao;
import model.Fruit;
import model.FruitDataDto;
import service.DataValidator;

public class Purchase implements ActivityHandler {
    private FruitDao fruitDao;
    private DataValidator dataValidator;

    public Purchase(FruitDao fruitDao, DataValidator dataValidator) {
        this.fruitDao = fruitDao;
        this.dataValidator = dataValidator;
    }

    @Override
    public boolean apply(FruitDataDto fruitDataDto) {
        Fruit fruit = new Fruit(fruitDataDto.getFruit());
        Integer newAmount = fruitDao.get(fruit).orElseThrow(() ->
                new RuntimeException("No such fruit in db")) - fruitDataDto.getAmount();
        dataValidator.validateAmount(newAmount);
        fruitDao.add(fruit, newAmount);
        return true;
    }
}
