package core.basesyntax.service;

import core.basesyntax.model.FruitItem;
import core.basesyntax.model.Item_Operation;

import java.util.HashMap;

public interface SaveFruitsToDB {
    HashMap<Item_Operation, FruitItem> saveToDB (String lineFromFile);
}
