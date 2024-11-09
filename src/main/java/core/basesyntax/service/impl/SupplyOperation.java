package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;

public class SupplyOperation implements OperationStrategy {
    private final FruitDao fruitDaoImpl;

    public SupplyOperation(FruitDao fruitDaoImpl) {
        this.fruitDaoImpl = fruitDaoImpl;
    }

    @Override
    public void execute(FruitTransaction fruitTransaction) {
        var fruit = fruitTransaction.getFruit();
        var quantity = fruitTransaction.getQuantity();
        fruitDaoImpl.supplyFruit(fruit, quantity);
    }
}
