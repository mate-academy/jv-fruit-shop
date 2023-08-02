package core.basesyntax.service.impl;

import core.basesyntax.handler.PurchaseHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class PurchaseServiceImpl implements OperationHandler {
    private final PurchaseHandler purchaseHandler;

    public PurchaseServiceImpl(PurchaseHandler purchaseHandler) {
        this.purchaseHandler = purchaseHandler;
    }

    @Override
    public boolean applyOperation(FruitTransaction fruitTransaction) {
        return purchaseHandler.purchase(fruitTransaction.getFruitName(),
                fruitTransaction.getFruitQuantity());
    }
}
