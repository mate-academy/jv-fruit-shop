package core.basesyntax.fruitstoreoperation;

import core.basesyntax.InputDataModel;

public class ReturnFruitOperation implements FruitStoreOperation {
    @Override
    public void doOperation(InputDataModel product, int amount) {
        SupplyFruitOperation supplyFruitOperation = new SupplyFruitOperation();
        supplyFruitOperation.doOperation(product,amount);
    }
}
