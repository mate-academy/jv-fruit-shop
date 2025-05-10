package core.basesyntax.service.impl;

import core.basesyntax.service.ReportToFile;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ReportToFileImpl implements ReportToFile {

    @Override
    public void writeReportToFile(List<String> report, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (String line : report) {
                writer.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to write the report to file: " + fileName, e);
        }
    }
}
