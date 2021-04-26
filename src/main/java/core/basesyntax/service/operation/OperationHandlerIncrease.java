package core.basesyntax.service.operation;

import core.basesyntax.model.Product;
import core.basesyntax.storage.Storage;
import java.util.Optional;

public class OperationHandlerIncrease implements OperationHandler {
    @Override
    public int apply(int amount, Product key) {
        Optional<Integer> fruitQuantity = Optional.ofNullable(Storage.productStorage.get(key));
        if (fruitQuantity.isPresent()) {
            int currentAmount = Storage.productStorage.get(key);
            return currentAmount + amount;
        }
        return amount;
    }
}
