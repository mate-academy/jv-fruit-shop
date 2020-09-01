package core.basesyntax.service;

import core.basesyntax.model.FruitBox;
import core.basesyntax.model.Storage;
import java.util.LinkedHashMap;
import java.util.Map;

public class StorageContent<T> {
    private StringBuilder fruitsString = new StringBuilder();
    private Map<String, Integer> storageContent = new LinkedHashMap<>();

    public String getStorage() {
        for (FruitBox fruitBox : Storage.storage) {
            if (storageContent.containsKey(fruitBox.getName())) {
                storageContent.replace(fruitBox.getName(),
                        storageContent.get(fruitBox.getName()) + fruitBox.getAmount());
            } else {
                storageContent.put(fruitBox.getName(), fruitBox.getAmount());
            }
        }
        for (String key : storageContent.keySet()) {
            fruitsString.append(key)
                    .append(",")
                    .append(storageContent.get(key))
                    .append("\n");
        }
        return fruitsString.toString();
    }
}
