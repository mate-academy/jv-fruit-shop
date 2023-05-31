package core.basesyntax.strategy;

import static javax.swing.UIManager.get;
import static javax.swing.UIManager.put;

import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int previousQuantity = (int) get(transaction.getFruit());
        put(transaction.getFruit(), previousQuantity + transaction.getQuantity());
    }
}
