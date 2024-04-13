package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ReportWriterToFileImpl implements ReportWriterToFile {
    @Override
    public void getReport() {
        String filePath = "src/main/resources/report.CSV";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, Integer> entry : ReportCreator.storageForReport.entrySet()) {
                String line = entry.getKey() + "," + entry.getValue();
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Data has written successful: " + filePath);
        } catch (IOException e) {
            throw new RuntimeException("Error during writing to file: " + e.getMessage());
        }
    }
}
