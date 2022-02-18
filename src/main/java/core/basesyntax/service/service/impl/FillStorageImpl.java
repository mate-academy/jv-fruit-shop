package core.basesyntax.service.service.impl;

import core.basesyntax.db.FruitsStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FillStorage;
import java.util.List;

public class FillStorageImpl implements FillStorage {
    public static final String COMA_SEPARATOR = ",";
    public static final int FRUIT_INDEX = 1;
    public static final int DEFAULT_QUANTITY_FOR_ONE_FRUIT = 0;
    public static final int COLUMN_NAME_LINE = 1;

    public void fill(List<String> data) {
        data.stream()
              .skip(COLUMN_NAME_LINE)
              .map(s -> s.split(COMA_SEPARATOR))
              .map(s -> s[FRUIT_INDEX])
              .distinct()
              .map(f -> new Fruit(f, DEFAULT_QUANTITY_FOR_ONE_FRUIT))
                .forEach(f -> FruitsStorage.getFruits().add(f));
    }
}
