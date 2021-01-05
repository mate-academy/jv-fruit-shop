package core.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CreateReportToCsv implements CreateReportToFile {
    private static final String FORMAT_FOR_REPORT =
            "fruit,quantity" + System.lineSeparator() + "%s";

    @Override
    public void write(String data, String path) {
        String reportToFile = String.format(FORMAT_FOR_REPORT, data) + System.lineSeparator();
        try (BufferedWriter writeFile = new BufferedWriter(new FileWriter(path))) {
            writeFile.write(reportToFile);
        } catch (IOException e) {
            throw new RuntimeException("Can't create a file!" + path, e);
        }
    }
}
