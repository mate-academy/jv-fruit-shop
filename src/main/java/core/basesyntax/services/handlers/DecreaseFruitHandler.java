package core.basesyntax.services.handlers;

import core.basesyntax.exception.ValidationException;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import java.util.Map;

public class DecreaseFruitHandler implements FruitHandler {
    @Override
    public int newQuantity(Operation operation, Map<Fruit, Integer> fruitStorage) {
        for (Map.Entry<Fruit, Integer> entry : fruitStorage.entrySet()) {
            if (entry.getKey().equals(operation.getFruit())) {
                return entry.getValue() - operation.getQuantity();
            }
        }
        throw new ValidationException("Incorrect operation type");
    }
}
