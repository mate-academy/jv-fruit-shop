package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    private final HandlerDataValidator dataValidator;

    public PurchaseOperationHandler() {
        this.dataValidator = new HandlerDataValidatorImpl();
    }

    @Override
    public void handle(String fruit, int quantity) {
        dataValidator.checkNull(fruit);
        dataValidator.checkNegative(quantity);
        if (Storage.storage.get(fruit) >= quantity) {
            Storage.storage.put(fruit, Storage.storage.get(fruit) - quantity);
        } else {
            throw new RuntimeException("You cannot sell more fruit than is available");
        }
    }
}
