package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public class PurchaseOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public PurchaseOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void operate(Fruit fruit) {
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
