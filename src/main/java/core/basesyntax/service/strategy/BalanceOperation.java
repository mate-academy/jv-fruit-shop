package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.LineData;
import core.basesyntax.service.Parser;

public class BalanceOperation implements Parser.OperationHandler {

    @Override
    public boolean operation(LineData lineData) {
        String fruitName = lineData.getFruitName();
        int quantity = lineData.getQuantity();
        Storage.store.put(new Fruit(fruitName), quantity);
        return true;
    }
}
