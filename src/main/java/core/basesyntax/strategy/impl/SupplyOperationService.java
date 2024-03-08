package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.OperationService;

public class SupplyOperationService implements OperationService {
    private final FruitDao fruitDao;

    public SupplyOperationService(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void execute(String fruitName, int quantity) {
        Fruit fruit = fruitDao.get(fruitName);
        if (quantity < 0) {
            throw new RuntimeException("Supply value can`t be negative");
        }
        int newQuantity = fruit.getQuantity() + quantity;
        fruit.setQuantity(newQuantity);
        fruitDao.update(fruit);
    }
}
