package core.basesyntax.strategy;

import core.basesyntax.model.FruitItem;
import core.basesyntax.model.Item_Operation;

import java.util.ArrayList;
import java.util.HashMap;

public interface FruitQuantityChange {
    HashMap<String, Integer> changeFruitQuantity(Item_Operation operation, FruitItem fruit);
}
