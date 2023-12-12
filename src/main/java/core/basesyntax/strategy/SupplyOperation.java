package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements Operation {
    private final FruitStorage fruitStorage;

    public SupplyOperation(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void performOperation(FruitTransaction transaction, FruitStorage fruitStorage) {
        fruitStorage.addFruit(transaction.getFruit(), transaction.getQuantity());
        System.out.println("Processed Supply Operation for "
                + transaction.getFruit()
                + ". Supplied: "
                + transaction.getQuantity());
    }
}
