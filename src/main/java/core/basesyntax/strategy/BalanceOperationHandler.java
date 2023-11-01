package core.basesyntax.strategy;

import core.basesyntax.data.FruitTransaction;
import java.util.Map;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void processWithData(FruitTransaction transaction, Map<String, Integer> data) {
        data.put(transaction.getFruit(), transaction.getQuantity());
    }
}
