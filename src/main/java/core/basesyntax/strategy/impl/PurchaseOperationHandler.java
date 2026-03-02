package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationsHandler;

public record PurchaseOperationHandler(FruitDao fruitDao) implements OperationsHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {

    }
}
