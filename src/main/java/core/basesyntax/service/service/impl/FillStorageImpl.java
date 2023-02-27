package core.basesyntax.service.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FillStorage;
import java.util.List;

public class FillStorageImpl implements FillStorage {
    public static final String HEADER_LINE = "type,fruit,quantity";
    public static final String SEPARATOR = ",";
    public static final int FRUIT_INDEX = 1;
    public static final int DEFAULT_QUANTITY = 0;

    public void fill(List<String> data) {
        if (data == null) {
            throw new RuntimeException("Can`t fill storage: null data");
        }
        data.remove(HEADER_LINE);
        data.stream()
                .map(str -> str.split(SEPARATOR))
                .map(str -> str[FRUIT_INDEX])
                .map(str -> str.replaceAll("\\W", ""))
                .map(str -> str.replaceAll("\\d", ""))
                .distinct()
                .map(frt -> new Fruit(frt, DEFAULT_QUANTITY))
                .forEach(frt -> Storage.getFruits().add(frt));
    }
}
