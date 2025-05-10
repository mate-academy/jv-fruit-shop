package core.basesyntax.strategy.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class Supplier implements OperationCompiler {
    @Override
    public void doOperation(FruitTransaction fruitTransaction) {
        Integer fruitBalance = Storage.fruits.get(fruitTransaction.getFruit());
        Storage.fruits.put(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity() + fruitBalance);
    }
}
