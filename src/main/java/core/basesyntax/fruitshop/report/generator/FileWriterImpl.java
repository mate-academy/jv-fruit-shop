package core.basesyntax.fruitshop.report.generator;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeReport(String report, String toFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(toFile))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't find the file", e);
        }
    }
}
