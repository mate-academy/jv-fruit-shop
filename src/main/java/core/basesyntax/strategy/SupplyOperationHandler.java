package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    private final FruitStorage fruitStorage;

    public SupplyOperationHandler(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void performOperation(FruitTransaction transaction) {
        fruitStorage.addFruit(transaction.getFruit(), transaction.getQuantity());
        System.out.println("Processed Supply Operation for "
                + transaction.getFruit()
                + ". Supplied: "
                + transaction.getQuantity());
    }
}
