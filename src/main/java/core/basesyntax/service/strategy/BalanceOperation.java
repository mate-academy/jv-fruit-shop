package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class BalanceOperation implements OperationHandler {

    @Override
    public void apply(Map<String, Integer> fruits, FruitTransaction transaction) {
        fruits.put(transaction.getFruit(), transaction.getQuantity());
    }
}
