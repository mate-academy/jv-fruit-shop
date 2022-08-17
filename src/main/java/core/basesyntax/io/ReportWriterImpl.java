package core.basesyntax.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReportWriterImpl implements ReportWriter {
    @Override
    public void writeToFile(String report, String pathToFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(pathToFile, false))) {
            bufferedWriter.append(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file: " + pathToFile, e);
        }
    }
}
