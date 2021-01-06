package core.basesyntax.model.impl;

import core.basesyntax.exception.InvalidOperationException;
import core.basesyntax.model.AbstractOperation;
import core.basesyntax.model.entities.Product;
import java.util.Map;

public class PurchaseOperation<T extends Product> extends AbstractOperation<T> {
    public PurchaseOperation(Map<T, Integer> storage) {
        super(storage);
    }

    @Override
    public void execute(T product, Integer amount) {
        validateExecution(product, amount);
        storage.merge(product, amount, (a, b) -> a - b);
    }

    private boolean validateExecution(T product, Integer amount) {
        if (!storage.containsKey(product) || storage.get(product) - amount < 0 || amount <= 0) {
            throw new InvalidOperationException(
                    "Incorrect amount for product " + product.getName());
        }
        return true;
    }
}
