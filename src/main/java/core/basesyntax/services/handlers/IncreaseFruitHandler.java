package core.basesyntax.services.handlers;

import core.basesyntax.model.Operation;
import java.util.Map;

public class IncreaseFruitHandler implements FruitHandler {

    @Override
    public int newQuantity(Operation operation, Map<String, Integer> fruitStorage) {
        int newQuantity = 0;
        for (Map.Entry<String, Integer> entry : fruitStorage.entrySet()) {
            if (entry.getKey().equals(operation.getFruit())) {
                newQuantity = entry.getValue() + operation.getQuantity();
            }
        }
        return newQuantity;
    }
}
