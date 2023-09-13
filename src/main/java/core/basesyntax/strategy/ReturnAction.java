package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;

public class ReturnAction implements Action {
    @Override
    public int action(Operation operation) {
        Integer actualAmount = Storage.storage.get(new Fruit(operation.getNameOfObject()));
        if (actualAmount == null) {
            throw new RuntimeException("Seems you try to return non-existing product "
                    + operation.getNameOfObject());
        }
        return actualAmount + operation.getAmount();
    }
}
