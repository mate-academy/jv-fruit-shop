package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.List;

public class FillStorage {
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
                .forEach(f -> Storage.getFruits().add(f));
    }
}
