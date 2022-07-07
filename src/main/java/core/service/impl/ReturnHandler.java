package core.service.impl;

import core.db.FruitTransaction;
import core.db.StorageService;
import core.service.OperationHandler;

public class ReturnHandler implements OperationHandler {
    private static final int OPERATION_SIGN = 1;

    @Override
    public void addTransaction(FruitTransaction transaction,
                               StorageService<FruitTransaction> storageService) {
        boolean fruitNoFound = storageService.getLeftovers().entrySet()
                .stream()
                .filter(entry -> entry.getKey().equals(transaction.getFruit()))
                .peek(entry -> entry.setValue(entry.getValue() + OPERATION_SIGN
                        * transaction.getQuantity()))
                .findFirst()
                .isEmpty();
        if (fruitNoFound) {
            storageService.getLeftovers().put(transaction.getFruit(), OPERATION_SIGN
                    * transaction.getQuantity());
        }
    }
}
