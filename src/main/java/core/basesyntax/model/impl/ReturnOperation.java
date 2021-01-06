package core.basesyntax.model.impl;

import core.basesyntax.exception.InvalidOperationException;
import core.basesyntax.model.AbstractOperation;
import core.basesyntax.model.entities.Product;
import java.util.Map;

public class ReturnOperation<T extends Product> extends AbstractOperation<T> {
    public ReturnOperation(Map<T, Integer> storage) {
        super(storage);
    }

    @Override
    public void execute(T product, Integer amount) {
        validateExecution(product, amount);
        storage.merge(product, amount, Integer::sum);
    }

    private void validateExecution(T product, Integer amount) {
        if (!storage.containsKey(product) || storage.get(product) - amount < 0 || amount <= 0) {
            throw new InvalidOperationException(
                    "Invalid return amount for product " + product.getName());
        }
    }
}
