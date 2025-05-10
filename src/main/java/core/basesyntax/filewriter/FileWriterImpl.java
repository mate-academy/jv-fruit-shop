package core.basesyntax.filewriter;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String resultingReport, String path) {
        String[] reportAsBits = resultingReport.trim().split(" ");

        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(path))) {
            writer.write("fruit,quantity");
            writer.newLine();

            for (String report : reportAsBits) {
                writer.write(report);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while reading the file.", e);
        }
    }
}
