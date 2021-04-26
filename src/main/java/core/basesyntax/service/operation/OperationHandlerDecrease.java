package core.basesyntax.service.operation;

import core.basesyntax.model.Product;
import core.basesyntax.storage.Storage;
import java.util.Optional;

public class OperationHandlerDecrease implements OperationHandler {
    private static final String EXCEPTION_MESSAGE = "You can't buy more fruits than in storage";

    @Override
    public int apply(int amount, Product key) {
        Optional<Integer> fruitQuantity = Optional.ofNullable(Storage.productStorage.get(key));
        if (fruitQuantity.isPresent() && fruitQuantity.get() > amount) {
            int currentAmount = Storage.productStorage.get(key);
            return currentAmount - amount;
        }
        throw new RuntimeException(EXCEPTION_MESSAGE);
    }
}
