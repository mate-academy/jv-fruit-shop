package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitReportService implements ReportService {
    public static final String FILE_CSV_TITLE = "fruit,quantity\n";
    private static final char CSV_SEPARATOR = ',';

    public String getReport() {
        final Map<Fruit, Integer> storage = Storage.storage;
        StringBuilder stringBuilder = new StringBuilder(FILE_CSV_TITLE);
        storage.forEach((key, value) -> stringBuilder
                .append(key.getName())
                .append(CSV_SEPARATOR)
                .append(value)
                .append(System.lineSeparator()));
        return stringBuilder.toString();
    }
}
