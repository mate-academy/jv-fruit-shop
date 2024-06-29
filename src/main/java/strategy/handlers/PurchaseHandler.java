package strategy.handlers;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;
import util.TransactionValidator;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        TransactionValidator.validate(transaction);
        int currentQuantity = Storage.getFruitQuantity(transaction.getFruit());
        if (currentQuantity < transaction.getQuantity()) {
            throw new IllegalArgumentException("Not enough fruit in stock to complete the purchase");
        }
        Storage.addFruit(transaction.getFruit(), -transaction.getQuantity());
    }
}

