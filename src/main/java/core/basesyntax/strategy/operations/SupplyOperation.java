package core.basesyntax.strategy.operations;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.Fruit;

public class SupplyOperation implements OperationHandler {
    private FruitsDao fruitsDao;

    public SupplyOperation(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void handle(String fruitName, int quantity) {
        Fruit fruit = fruitsDao.getFruit(fruitName);
        fruit.setQuantity(fruit.getQuantity() + quantity);
    }
}
