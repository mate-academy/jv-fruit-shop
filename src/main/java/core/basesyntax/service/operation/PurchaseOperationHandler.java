package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.impl.DataValidatorService;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public Fruit completeOperation(Fruit fruit) {
        DataValidatorService validatorService = new DataValidatorService();

        Integer oldQuantity = Storage.storage.get(fruit.getName());
        validatorService.isValidQuantityToPurchase(oldQuantity, fruit.getQuantity());
        Integer newQuantity = oldQuantity - fruit.getQuantity();

        return new Fruit(fruit.getName(), newQuantity, null);
    }
}
