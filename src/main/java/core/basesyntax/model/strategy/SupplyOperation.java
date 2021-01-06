package core.basesyntax.model.strategy;

import core.basesyntax.exception.InvalidOperationException;
import core.basesyntax.model.entities.Product;
import java.util.Map;

public class SupplyOperation<T extends Product> extends AbstractOperation<T> {
    public SupplyOperation(Map<T, Integer> storage) {
        super(storage);
    }

    @Override
    public void execute(T product, Integer amount) {
        validateExecution(amount);
        storage.merge(product, amount, Integer::sum);
    }

    private boolean validateExecution(Integer amount) {
        if (amount <= 0) {
            throw new InvalidOperationException("Negative amount cannot be processed");
        }
        return true;
    }
}
