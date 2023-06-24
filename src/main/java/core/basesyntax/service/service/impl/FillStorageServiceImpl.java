package core.basesyntax.service.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FillStorageService;
import java.util.List;

public class FillStorageServiceImpl implements FillStorageService {
    private static final String SEPARATOR = ",";
    private static final int FRUIT_INDEX = 1;
    private static final int DEFAULT_QUANTITY = 0;

    public void fill(List<String> data) {
        if (data == null) {
            throw new IllegalArgumentException("Can`t fill storage: null data");
        }

        data.subList(1, data.size())
                .stream()
                .map(string -> string.split(SEPARATOR))
                .map(strings -> strings[FRUIT_INDEX])
                .map(string -> string.replaceAll("\\W", ""))
                .map(string -> string.replaceAll("\\d", ""))
                .distinct()
                .map(fruit -> new Fruit(fruit, DEFAULT_QUANTITY))
                .forEach(fruit -> Storage.getFruits().add(fruit));
    }
}
