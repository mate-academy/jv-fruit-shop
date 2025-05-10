package core.basesyntax.servicehandler;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class SupplyHandler implements FruitOperationHandler {
    private final Map<String, Integer> fruitStorage;

    public SupplyHandler(Map<String, Integer> fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        fruitStorage.put(transaction.getFruit(),
                fruitStorage.getOrDefault(transaction.getFruit(), 0) + transaction.getQuantity());
    }
}
