package core.basesyntax.service.fruitservice;

import core.basesyntax.db.Storage;

public class FruitServiceImpl implements FruitService {
    private static final String SEPARATOR = ",";
    private static final String HEAD_LINE = "fruit,quantity";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder(HEAD_LINE);
        Storage.storage.forEach((key, value)
                -> report.append(System.lineSeparator())
                .append(key.getName())
                .append(SEPARATOR)
                .append(value));
        return report.toString();
    }
}
