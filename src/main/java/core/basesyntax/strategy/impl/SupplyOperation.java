package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperation implements OperationHandler {
    private final FruitDao fruitDao;

    public SupplyOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int quantityToSupply = transaction.getQuantity();
        int currentQuantity = fruitDao.get(fruitName);
        int newQuantity = currentQuantity + quantityToSupply;
        fruitDao.update(fruitName, newQuantity);
    }
}
