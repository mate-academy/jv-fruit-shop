package core.basesyntax.operationhandlers;

import core.basesyntax.model.FruitTransaction;

public class SubtractHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantityForSale = fruitTransaction.getQuantity();
        int quantityAvailable = FRUIT_STORAGE_DAO.get(fruit);
        if (quantityAvailable < quantityForSale) {
            throw new RuntimeException("You don't have enough goods");
        }
        if (quantityForSale < 0) {
            throw new RuntimeException("Purchase of a negative quantity of goods is impossible");
        }
        FRUIT_STORAGE_DAO.replace(fruit, quantityAvailable - quantityForSale);
    }
}
