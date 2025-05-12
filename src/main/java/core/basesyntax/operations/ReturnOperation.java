package core.basesyntax.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;
import java.util.Optional;

public class ReturnOperation implements OperationHandler {
    @Override
    public void getCalculation(FruitTransaction fruitTransaction) {

        if (Storage.fruits.isEmpty()) {
            throw new RuntimeException("Fruit's list is empty");
        }
        if (Storage.fruits.containsKey(fruitTransaction.getFruit())) {
            Optional<Map.Entry<String, Integer>> fruitEntry = Storage.fruits.entrySet().stream()
                    .filter(entry -> entry.getKey().equals(fruitTransaction.getFruit()))
                    .map(entry -> Map.entry(
                            entry.getKey(), entry.getValue() + fruitTransaction.getQuantity()))
                    .findFirst();
            Storage.fruits.put(fruitEntry.get().getKey(), fruitEntry.get().getValue());
        }
    }
}
