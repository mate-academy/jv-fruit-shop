package core.basesyntax.service;

import core.basesyntax.model.FruitBox;
import java.util.Map;

public class Supply extends Operation {
    public Supply(OperationType type, FruitBox fruit) {
        super(type, fruit);
    }

    @Override
    public Map<String, FruitBox> changeQuantity(int totalAmount,
                                                Map<String, FruitBox> storage) {
        String fruitName = fruitBox.getFruitType();
        int amount = fruitBox.getQuantity();
        if (storage.containsKey(fruitName)) {
            storage.get(fruitName).setQuantity(storage.get(fruitName).getQuantity() + amount);
        } else {
            storage.put(fruitName, fruitBox);
        }
        return storage;
    }
}
