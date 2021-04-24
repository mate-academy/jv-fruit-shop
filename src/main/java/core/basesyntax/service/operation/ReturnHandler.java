package core.basesyntax.service.operation;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;
import java.util.Optional;

public class ReturnHandler implements OperationHandler {
    @Override
    public int apply(int amount, Fruit key) {
        if (Optional.ofNullable(Storage.productStorage.get(key)).isPresent()) {
            int currentAmount = Storage.productStorage.get(key);
            return currentAmount + amount;
        }
        return amount;
    }
}
