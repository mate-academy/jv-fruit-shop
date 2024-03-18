package core.basesyntax.strategy;

import core.basesyntax.model.FruitItem;
import java.util.HashMap;

public interface FruitQuantityChange {
    public HashMap<String, Integer> changeFruitQuantity(FruitItem fruit);
}
