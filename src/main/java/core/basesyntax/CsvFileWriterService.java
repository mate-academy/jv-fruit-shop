package core.basesyntax;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CsvFileWriterService {
    public void writeReport(List<String> report, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (String line : report) {
                writer.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to write report to file: " + filePath, e);
        }
    }
}
