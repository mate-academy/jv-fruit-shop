package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.OperationService;
import java.util.Map;

public class BalanceOperationService implements OperationService {
    @Override
    public void calculateQuantity(FruitTransaction fruit) {
        for (Map.Entry<String, Integer> entry :
                Storage.storage.entrySet()) {
            if (fruit.getFruit().equals(entry.getKey())) {
                entry.setValue(fruit.getQuantity());
            }
        }
    }
}
