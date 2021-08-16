package core.basesyntax.service;

import core.basesyntax.model.Operation;
import java.math.BigDecimal;
import java.util.function.Predicate;

public class FileDataValidator implements Predicate<Operation> {
    @Override
    public boolean test(Operation operation) {
        if (operation.getFruitName().isEmpty()
                || operation.getQuantity().compareTo(new BigDecimal(0)) < 0) {
            throw new RuntimeException("Validation data didn't pass! Data is incorrect!");
        }
        return true;
    }
}
