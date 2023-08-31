package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.OperationHandler;
import java.util.Map;

public class BalanceOperationService implements OperationHandler {
    @Override
    public void handler(FruitTransaction fruit) {
        for (Map.Entry<String, Integer> entry :
                Storage.storage.entrySet()) {
            if (fruit.getFruit().equals(entry.getKey())) {
                entry.setValue(fruit.getQuantity());
            }
        }
    }
}
