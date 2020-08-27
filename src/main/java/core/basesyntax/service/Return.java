package core.basesyntax.service;

import core.basesyntax.model.FruitBox;
import java.util.Map;

public class Return extends Operation {
    public Return(OperationType type, FruitBox fruit) {
        super(type, fruit);
    }

    @Override
    public Map<String, FruitBox> changeQuantity(int totalAmount,
                                                Map<String, FruitBox> storage) {
        for (FruitBox fruitBox: storage.values()) {
            if (fruitBox.getDate().isEqual(fruit.getDate())) {
                fruitBox.setQuantity(fruitBox.getQuantity() + fruit.getQuantity());
            }
        }
        return storage;
    }
}
