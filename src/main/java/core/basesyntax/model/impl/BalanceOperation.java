package core.basesyntax.model.impl;

import core.basesyntax.exception.InvalidOperationException;
import core.basesyntax.model.AbstractOperation;
import core.basesyntax.model.entities.Product;
import java.util.Map;

public class BalanceOperation<T extends Product> extends AbstractOperation<T> {
    public BalanceOperation(Map<T, Integer> storage) {
        super(storage);
    }

    @Override
    public void execute(T product, Integer amount) {
        validateExecution(product);
        storage.put(product, amount);
    }

    private boolean validateExecution(T product) {
        if (storage.containsKey(product)) {
            throw new InvalidOperationException(
                    "More than one Balance operation found for product " + product.getName());
        }
        return true;
    }
}
