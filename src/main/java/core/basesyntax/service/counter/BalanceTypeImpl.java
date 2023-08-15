package core.basesyntax.service.counter;

import core.basesyntax.service.transaction.FruitTransaction;
import java.util.Map;

public class BalanceTypeImpl implements OperationType {

    @Override
    public void countFruits(Map<String, Integer> fruitTypesAndQuantity,
                            FruitTransaction fruitTransaction) {
        fruitTypesAndQuantity.put(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
