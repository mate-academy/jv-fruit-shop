package core.basesyntax.service.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void updateDataBase(FruitTransaction transaction) {
        if (FruitStorage.fruitStorage.get(transaction.getFruit()) == null) {
            throw new RuntimeException("First you need to enter the balance of "
                    + transaction.getFruit() + " under the code 'b'");
        }
        for (Map.Entry<String, Integer> entry : FruitStorage.fruitStorage.entrySet()) {
            if (transaction.getFruit().equals(entry.getKey())) {
                if (entry.getValue() - transaction.getQuantity() < 0) {
                    throw new RuntimeException("The balance after the transaction"
                            + " cannot be negative.");
                }
                entry.setValue(entry.getValue() - transaction.getQuantity());
            }
        }
    }
}
