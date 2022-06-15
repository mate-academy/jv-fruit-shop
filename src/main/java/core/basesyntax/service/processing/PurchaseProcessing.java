package core.basesyntax.service.processing;

import core.basesyntax.dao.FruitsDaoImpl;

public class PurchaseProcessing extends FruitsDaoImpl implements OperationProcessing {

    @Override
    public void doAction(String fruit, int amount) {
        subtract(fruit, amount);
    }
}
