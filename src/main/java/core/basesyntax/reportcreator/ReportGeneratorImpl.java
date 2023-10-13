package core.basesyntax.reportcreator;

import core.basesyntax.db.Storage;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String SEPARATOR = ",";
    private static final String HEADER = "fruit,quantity";

    @Override
    public String generateReport() {
        StringBuilder stringBuilder = new StringBuilder(HEADER);
        for (String key : Storage.getFruits().keySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(key)
                    .append(SEPARATOR).append(Storage.getFruits().get(key));
        }
        return stringBuilder.toString();
    }
}
