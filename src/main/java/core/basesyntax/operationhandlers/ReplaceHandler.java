package core.basesyntax.operationhandlers;

import core.basesyntax.model.FruitTransaction;

public class ReplaceHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("It is impossible to get a negative quantity of goods");
        }
        FRUIT_STORAGE_DAO
                .replace(fruit, FRUIT_STORAGE_DAO.get(fruit) + fruitTransaction.getQuantity());
    }
}
