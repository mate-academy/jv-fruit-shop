package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.StorageActions;
import java.util.Map;

public class StorageActionsImpl implements StorageActions {

    @Override
    public void removeFromStorage(String fruitType, int quantity) {
        if (Storage.storageContents.containsKey(fruitType)) {
            for (Map.Entry<String, Integer> entry : Storage.storageContents.entrySet()) {
                if (entry.getKey().equals(fruitType)) {
                    int newAmount = entry.getValue() - quantity;
                    entry.setValue(newAmount);
                    return;
                }
            }
        } else {
            throw new RuntimeException("No such fruitCategory " + fruitType);
        }
    }

    @Override
    public void addToStorage(String fruitType, int quantity) {
        if (Storage.storageContents.containsKey(fruitType)) {
            for (Map.Entry<String, Integer> entry : Storage.storageContents.entrySet()) {
                if (entry.getKey().equals(fruitType)) {
                    int newAmount = entry.getValue() + quantity;
                    entry.setValue(newAmount);
                    return;
                }
            }
        } else {
            Storage.storageContents.put(fruitType,quantity);
        }
    }
}
