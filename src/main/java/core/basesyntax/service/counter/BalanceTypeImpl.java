package core.basesyntax.service.counter;

import core.basesyntax.dao.Storage;
import core.basesyntax.service.transaction.FruitTransaction;

public class BalanceTypeImpl implements OperationType {

    @Override
    public void makeOperationWithFruit(FruitTransaction fruitTransaction) {
        Storage.getFruitTypesAndQuantity().put(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
