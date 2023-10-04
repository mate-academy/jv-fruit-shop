package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;

public class SupplyOperationHandler implements OperationHandler {
    private final HandlerDataValidator dataValidator;

    public SupplyOperationHandler(HandlerDataValidator dataValidator) {
        this.dataValidator = new HandlerDataValidatorImpl();
    }

    @Override
    public void handle(String fruit, int quantity) {
        dataValidator.checkNull(fruit);
        dataValidator.checkNegative(quantity);
        Storage.storage.put(fruit, Storage.storage.get(fruit) + quantity);
    }
}

