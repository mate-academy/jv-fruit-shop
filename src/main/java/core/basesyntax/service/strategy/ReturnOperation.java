package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class ReturnOperation implements OperationHandler {

    @Override
    public void apply(Map<String, Integer> fruits, FruitTransaction transaction) {
        fruits.merge(transaction.getFruit(), transaction.getQuantity(), Integer::sum);
    }
}
