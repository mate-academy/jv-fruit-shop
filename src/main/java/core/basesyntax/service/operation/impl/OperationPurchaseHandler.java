package core.basesyntax.service.operation.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;

public class OperationPurchaseHandler implements OperationHandler {
    private static final String SEPARATOR_FOR_LINE_OPERATION_PRODUCTS_QUANTITY = ",";

    @Override
    public void operationHandler(FruitTransaction fruitTransaction) {
        int quantityFromDb = operationDao.get(fruitTransaction.getFruit());
        if (quantityFromDb - fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("There are not enough products to sell: "
                    + fruitTransaction.getOperation().getCode()
                    + SEPARATOR_FOR_LINE_OPERATION_PRODUCTS_QUANTITY
                    + fruitTransaction.getFruit()
                    + SEPARATOR_FOR_LINE_OPERATION_PRODUCTS_QUANTITY
                    + fruitTransaction.getQuantity());
        }
        operationDao.put(fruitTransaction.getFruit(),quantityFromDb
                - fruitTransaction.getQuantity());
    }
}
