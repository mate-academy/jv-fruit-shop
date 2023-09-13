package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;

public class SupplyAction implements Action {

    @Override
    public int action(Operation operation) {
        Integer value = Storage.storage.get(new Fruit(operation.getNameOfObject()));
        if (value != null) {
            return operation.getAmount() + value;
        }
        return operation.getAmount();
    }
}
