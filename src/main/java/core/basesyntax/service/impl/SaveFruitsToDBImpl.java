package core.basesyntax.service.impl;

import core.basesyntax.model.FruitItem;
import core.basesyntax.model.Item_Operation;
import core.basesyntax.service.interfaces.FruitRawStringParser;

import java.util.HashMap;

public class SaveFruitsToDBImpl implements FruitRawStringParser {
    @Override
    public HashMap<Item_Operation, FruitItem> saveToDB(String lineFromFile) {
        HashMap<String,Integer> newFruit = new HashMap<>();
        newFruit.put(fruit.getFruitName(), fruit.getFruitQuantity());
        return null;
    }
}
