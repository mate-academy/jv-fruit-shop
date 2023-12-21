package strategy;

import db.Storage;
import java.util.Map;
import model.FruitTransaction;

public class CalculateStrategy {
    private final Storage storage;
    private final Map<String, Integer> fruitQuantities;

    public CalculateStrategy(Storage storage, Map<String, Integer> fruitQuantities) {
        this.storage = storage;
        this.fruitQuantities = fruitQuantities;
    }

    public void setOperation(FruitTransaction fruitTransaction) {
        int storageValue = 0;

        switch (fruitTransaction.getOperation()) {
            case BALANCE -> {
                storage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
                break;
            }
            case SUPPLY, RETURN -> {
                Integer currentQuantity = storage.get(fruitTransaction.getFruit());
                if (currentQuantity != null) {
                    storageValue = currentQuantity;
                }
                storage.put(fruitTransaction.getFruit(),
                        storageValue + fruitTransaction.getQuantity());
                break;
            }
            case PURCHASE -> {
                Integer currentQuantity = storage.get(fruitTransaction.getFruit());
                if (currentQuantity != null) {
                    storageValue = currentQuantity;
                }
                storage.put(fruitTransaction.getFruit(),
                        storageValue - fruitTransaction.getQuantity());
                break;
            }
            default -> throw new IllegalArgumentException("Unexpected operation: "
                        + fruitTransaction.getOperation());
        }
        fruitQuantities.put(fruitTransaction.getFruit(),
                storage.get(fruitTransaction.getFruit()));
    }
}
