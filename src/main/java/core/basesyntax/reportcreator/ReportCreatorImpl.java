package core.basesyntax.reportcreator;

import core.basesyntax.db.Storage;

public class ReportCreatorImpl implements ReportCreator {
    private static final String SEPARATOR = ",";

    @Override
    public String generateReport() {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity");
        for (String key : Storage.fruits.keySet()) {
            stringBuilder.append("\n")
                    .append(key)
                    .append(SEPARATOR).append(Storage.fruits.get(key));
        }
        return stringBuilder.toString();
    }
}

