package strategy.handlers;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;
import util.TransactionValidator;

public class BalanceHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        TransactionValidator.validate(transaction);
        Storage.addFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
