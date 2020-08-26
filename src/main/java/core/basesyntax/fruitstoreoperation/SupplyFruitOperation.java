package core.basesyntax.fruitstoreoperation;

import core.basesyntax.FruitStoreDao;
import core.basesyntax.InputDataModel;

public class SupplyFruitOperation implements FruitStoreOperation {
    private FruitStoreDao fruitStoreDao = new FruitStoreDao();

    public void doOperation(InputDataModel product, int amount) {
        fruitStoreDao.addFruitProduct(product, amount);
    }
}
