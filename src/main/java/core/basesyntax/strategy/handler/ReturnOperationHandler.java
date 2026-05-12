package core.basesyntax.strategy.handler;

import core.basesyntax.transaction.FruitTransaction;
import core.basesyntax.transaction.Transaction;

public class ReturnOperationHandler implements OperationHandler {

    @Override
    public void handle(FruitTransaction ft, Transaction tx) {
        tx.add(ft.getFruit(), ft.getQuantity());
    }
}
