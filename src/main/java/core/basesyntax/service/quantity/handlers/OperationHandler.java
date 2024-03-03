package core.basesyntax.service.quantity.handlers;

import core.basesyntax.entity.FruitTransaction;
import java.util.Map;

public interface OperationHandler {

    void handleTransaction(FruitTransaction fruitTransaction, Map<String,Integer> fruitMap);
}
