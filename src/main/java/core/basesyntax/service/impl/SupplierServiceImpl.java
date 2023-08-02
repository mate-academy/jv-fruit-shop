package core.basesyntax.service.impl;

import core.basesyntax.handler.SupplierHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class SupplierServiceImpl implements OperationHandler {
    private final SupplierHandler supplierHandler;

    public SupplierServiceImpl(SupplierHandler supplierHandler) {
        this.supplierHandler = supplierHandler;
    }

    @Override
    public boolean applyOperation(FruitTransaction fruitTransaction) {
        FruitTransaction newFruit = new FruitTransaction.FruitBuilder()
                .setOperationType(fruitTransaction.getOperationType())
                .setFruitName(fruitTransaction.getFruitName())
                .setFruitQuantity(fruitTransaction.getFruitQuantity())
                .setOperationType(fruitTransaction.getOperationType())
                .build();
        return supplierHandler.add(newFruit);
    }
}
