package core.basesyntax.operationhandlers;

import core.basesyntax.model.FruitTransaction;

public class AddHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("Balance couldn't be less than zero");
        }
        FRUIT_STORAGE_DAO.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
