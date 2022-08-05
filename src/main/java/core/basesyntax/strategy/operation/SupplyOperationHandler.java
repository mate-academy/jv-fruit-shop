package core.basesyntax.strategy.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        addNewFruitBalance(transaction.getFruit(),
                removeOldFruitBalance(transaction.getFruit()) + transaction.getQuantity());
    }

    private Integer removeOldFruitBalance(Fruit fruit) {
        Integer oldFruitBalance = FruitStorage.fruitsMap.remove(fruit);
        return oldFruitBalance == null ? 0 : oldFruitBalance;
    }

    private void addNewFruitBalance(Fruit fruit, Integer quantity) {
        FruitStorage.fruitsMap.put(fruit, quantity);
    }
}
