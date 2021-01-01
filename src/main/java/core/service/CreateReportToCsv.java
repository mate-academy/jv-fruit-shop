package core.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CreateReportToCsv implements CreateReportToFile {
    private static final String FORMAT_FOR_REPORT =
            "fruit,quantity" + System.lineSeparator() + "%s";

    @Override
    public void createReport(String reportData, String toFileName) {
        String reportToFile = String.format(FORMAT_FOR_REPORT, reportData) + System.lineSeparator();
        try (BufferedWriter writeFile = new BufferedWriter(new FileWriter(toFileName))) {
            writeFile.write(reportToFile);
        } catch (IOException e) {
            throw new RuntimeException("Can't create a file!" + toFileName, e);
        }
    }
}
