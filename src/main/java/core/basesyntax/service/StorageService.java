package core.basesyntax.service;

import core.basesyntax.model.FruitBox;
import core.basesyntax.model.Storage;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StorageService<T> {
    private static final String BANANA_FRUIT_TYPE = "banana";
    private List<String> fruits = new ArrayList<>();

    public String getStorage() {
        fruits.add(BANANA_FRUIT_TYPE);
        Map<String, Integer> storageContent = new LinkedHashMap<>();
        mark: for (FruitBox fruitBox : Storage.storage) {
            switch (fruitBox.getName()) {
                case BANANA_FRUIT_TYPE:
                    if (storageContent.containsKey(BANANA_FRUIT_TYPE)) {
                        storageContent.replace(BANANA_FRUIT_TYPE,
                                storageContent.get(BANANA_FRUIT_TYPE) + fruitBox.getAmount());
                    }
                    storageContent.put(BANANA_FRUIT_TYPE, fruitBox.getAmount());
                    continue mark;
                default:
                    throw new RuntimeException("Unknown fruit");
            }
        }
        StringBuilder fruitsString = new StringBuilder();
        for (int i = 0; i < storageContent.size(); i++) {
            fruitsString.append(fruits.get(i))
                    .append(",")
                    .append(storageContent.get(fruits.get(i)))
                    .append("\n");
        }
        return fruitsString.toString();
    }
}
