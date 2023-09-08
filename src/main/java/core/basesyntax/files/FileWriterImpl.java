package core.basesyntax.files;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {

    @Override
    public void write(String reportPath, String report) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(reportPath))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file " + reportPath, e);
        }
    }
}
