package core.basesyntax.service.processing;

import core.basesyntax.dao.FruitsDaoImpl;

public class SupplyProcessing extends FruitsDaoImpl implements OperationProcessing {

    @Override
    public void doAction(String fruit, int amount) {
        add(fruit, amount);
    }
}
