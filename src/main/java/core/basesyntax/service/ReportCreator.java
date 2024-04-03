package core.basesyntax.service;

import core.basesyntax.db.Storage;

public class ReportCreator {
    private static final String DELIMITER = ",";

    public String createReport(Storage storage) {
        StringBuilder report = new StringBuilder("fruit,quantity" + System.lineSeparator());
        int index = 0;
        int size = storage.getFruits().size();
        for (String key : storage.getFruits().keySet()) {
            report.append(key + DELIMITER + storage.getFruits().get(key));
            if (++index < size) {
                report.append(System.lineSeparator());
            }
        }
        return report.toString();
    }
}
