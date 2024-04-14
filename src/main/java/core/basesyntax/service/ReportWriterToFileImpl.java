package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReportWriterToFileImpl implements ReportWriterToFile {
    @Override
    public void getReport(String filePath) {
        ReportCreator reportCreator = new ReportCreator();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : reportCreator.constructingLines(ReportCreator.storageForReport)) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error during writing to file: " + e.getMessage());
        }
    }
}
