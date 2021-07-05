package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitReport {
    public static final String FILE_CSV_TITLE = "fruit,quantity\n";
    private static final char CSV_SEPARATOR = ',';
    private final Map<Fruit, Integer> storage;

    public FruitReport() {
        this.storage = Storage.storage;
    }

    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder(FILE_CSV_TITLE);
        storage.forEach((key, value) -> stringBuilder
            .append(key.getName())
            .append(CSV_SEPARATOR)
            .append(value)
            .append(System.lineSeparator()));
        return stringBuilder.toString();
    }
}
