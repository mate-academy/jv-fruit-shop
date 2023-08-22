package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void operate(Fruit fruit, FruitDao fruitDao) {
        int currentQuantity = fruitDao.get(fruit.getName()).getQuantity();
        int newQuantity = currentQuantity + fruit.getQuantity();
        fruit.setQuantity(newQuantity);
        fruitDao.update(fruit);
    }
}
