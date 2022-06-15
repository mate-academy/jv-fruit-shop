package core.basesyntax.service.processing;

import core.basesyntax.dao.FruitsDaoImpl;

public class BalanceProcessing extends FruitsDaoImpl implements OperationProcessing {
    @Override
    public void doAction(String fruit, int amount) {
        add(fruit, amount);
    }
}
