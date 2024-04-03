package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.io.FileWriter;
import java.io.IOException;

public class ReportCreator {
    private static final String REPORT_FILE_NAME = "src/main/resources/report.csv";
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
        try (FileWriter fileWriter = new FileWriter(REPORT_FILE_NAME)) {
            fileWriter.write(report.toString());
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + REPORT_FILE_NAME, e);
        }
        return report.toString();
    }
}
