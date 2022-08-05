package core.basesyntax.strategy.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitTransaction;

public interface OperationHandler {
    void doTransaction(FruitTransaction transaction);

    default void addToBalance(FruitTransaction transaction) {
        addNewFruitBalance(transaction.getFruit(),
                removeOldFruitBalance(transaction.getFruit()) + transaction.getQuantity());
    }

    default void subtractFromBalance(FruitTransaction transaction) {
        addNewFruitBalance(transaction.getFruit(),
                removeOldFruitBalance(transaction.getFruit()) - transaction.getQuantity());
    }

    private Integer removeOldFruitBalance(Fruit fruit) {
        Integer oldFruitBalance = FruitStorage.fruitNumbersMap.remove(fruit);
        return oldFruitBalance == null ? 0 : oldFruitBalance;
    }

    private void addNewFruitBalance(Fruit fruit, Integer quantity) {
        FruitStorage.fruitNumbersMap.put(fruit, quantity);
    }
}
