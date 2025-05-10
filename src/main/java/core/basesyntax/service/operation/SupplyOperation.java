package core.basesyntax.service.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void updateStorage(FruitTransaction transaction) {
        if (FruitStorage.fruitStorage.get(transaction.getFruit()) == null) {
            throw new RuntimeException("Before entering data for the operation "
                    + transaction.getOperation() + ", you must enter the BALANCE operation of "
                    + transaction.getFruit() + " under the code 'b'");
        }
        FruitStorage.fruitStorage.put(transaction.getFruit(),
                FruitStorage.fruitStorage.get(transaction.getFruit())
                        + transaction.getQuantity());
    }
}
