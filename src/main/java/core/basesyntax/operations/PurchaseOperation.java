package core.basesyntax.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;
import java.util.Optional;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void getCalculation(FruitTransaction fruitTransaction) {

        if (Storage.fruits.isEmpty()) {
            throw new RuntimeException("Fruit's list is empty");
        }
        if (Storage.fruits.containsKey(fruitTransaction.getFruit())) {
            Optional<Map.Entry<String, Integer>> fruitEntry = Storage.fruits.entrySet().stream()
                    .filter(entry -> entry.getKey().equals(fruitTransaction.getFruit()))
                    .map(entry -> {
                        if (entry.getValue() - fruitTransaction.getQuantity() > 0) {
                            return Map.entry(entry.getKey(),
                                    entry.getValue() - fruitTransaction.getQuantity());
                        } else {
                            throw new RuntimeException("Value is negative");
                        }
                    })
                    .findFirst();
            Storage.fruits.put(fruitEntry.get().getKey(), fruitEntry.get().getValue());
        } else {
            throw new RuntimeException("Such fruit doest exist" + fruitTransaction.getFruit());
        }
    }
}
