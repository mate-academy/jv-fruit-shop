package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;

public class PurchaseAction implements Action {

    @Override
    public int action(Operation operation) {
        int actualAmount = Storage.storage.get(new Fruit(operation.getNameOfObject()));
        if (actualAmount < operation.getAmount()) {
            throw new RuntimeException("Not enough product "
                    + operation.getNameOfObject()
                    + ", actual amount is "
                    + actualAmount
                    + ", while "
                    + operation.getAmount()
                    + " requested");
        }
        return actualAmount - operation.getAmount();
    }
}
