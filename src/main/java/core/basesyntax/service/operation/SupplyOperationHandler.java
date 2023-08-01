package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public Fruit completeOperation(Fruit fruit) {
        Integer newQuantity = Storage.storage.get(fruit.getName()) + fruit.getQuantity();
        return new Fruit(fruit.getName(), newQuantity, null);
    }
}
