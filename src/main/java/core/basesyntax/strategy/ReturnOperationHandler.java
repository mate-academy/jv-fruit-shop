package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public class ReturnOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public ReturnOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void operate(Fruit fruit) {
        int currentQuantity = fruitDao.get(fruit.getName()).getQuantity();
        int newQuantity = currentQuantity + fruit.getQuantity();
        fruit.setQuantity(newQuantity);
        fruitDao.update(fruit);
    }
}
