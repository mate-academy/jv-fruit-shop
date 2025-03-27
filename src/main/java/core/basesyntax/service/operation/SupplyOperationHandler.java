package core.basesyntax.service.operation;

import static core.basesyntax.db.Storage.addFruit;

import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        addFruit(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
