package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitItem;
import java.util.HashMap;

public interface FruitQuantityChange {
    HashMap<String, Integer> changeFruitQuantity(FruitItem fruit);
}
