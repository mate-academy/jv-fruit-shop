package core.basesyntax.service.calculator;

import core.basesyntax.db.Storage;
import core.basesyntax.service.operation.FruitOperation;

public class ReturnCalculatorImpl implements OperationCalculator {
    @Override
    public void handle(FruitOperation fruitTransaction) {
        Storage.getFruitKindsAndQuantity().put(fruitTransaction.getFruit(),
                Storage.getFruitKindsAndQuantity().get(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity());
    }
}
