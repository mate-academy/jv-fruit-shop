package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.LineData;

public class BalanceOperation implements OperationHandler {
    public boolean operate(LineData lineData) {
        Fruit fruitName = lineData.getFruitName();
        int quantity = lineData.getQuantity();
        Storage.store.put(new Fruit(fruitName.toString()), quantity);
        return true;
    }
}
