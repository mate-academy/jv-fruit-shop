package core.basesyntax.service;

import core.basesyntax.model.Operation;
import java.util.function.Consumer;

public class FileDataValidator implements Consumer<Operation> {
    @Override
    public void accept(Operation operation) {
        if (operation.getFruitName().isEmpty()
                || operation.getQuantity() < 0) {
            throw new RuntimeException("Validation data didn't pass! Data is incorrect!");
        }
    }
}
