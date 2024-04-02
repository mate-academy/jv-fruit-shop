package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.io.FileWriter;
import java.io.IOException;

public class ReportCreator {
    public static String createReport(Storage storage) {
        String fileReportName = "src/main/resources/report.csv";
        StringBuilder report = new StringBuilder("fruit,quantity" + System.lineSeparator());
        int index = 0;
        int size = storage.getFruits().size();
        for (String key : storage.getFruits().keySet()) {
            report.append(key + "," + storage.getFruits().get(key));
            if (++index < size) {
                report.append(System.lineSeparator());
            }
        }
        try (FileWriter fileWriter = new FileWriter(fileReportName)) {
            fileWriter.write(report.toString());
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + fileReportName, e);
        }
        return report.toString();
    }
}
