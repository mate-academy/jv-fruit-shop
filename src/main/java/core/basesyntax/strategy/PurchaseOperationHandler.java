package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void operate(Fruit fruit, FruitDao fruitDao) {
        int currentQuantity = fruitDao.get(fruit.getName()).getQuantity();
        if (currentQuantity < fruit.getQuantity()) {
            throw new RuntimeException(String.format("%d %s is not enough to sell %d %s.",
                    currentQuantity, fruit.getName(),
                    fruit.getQuantity(), fruit.getName()));
        }
        int newQuantity = currentQuantity - fruit.getQuantity();
        fruit.setQuantity(newQuantity);
        fruitDao.update(fruit);
    }
}
