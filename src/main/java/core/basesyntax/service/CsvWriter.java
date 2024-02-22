package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CsvWriter implements FileWriter {
    public void writeReportToFile(String outputPath, String contentToWrite) {
        String timeStamp = outputPath.substring(
                outputPath.indexOf('_') + 1, outputPath.indexOf('.'));
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(outputPath, true))) {
            if (Files.size(Paths.get(outputPath)) == 0) {
                writer.write("fruit,quantity\n");
            }
            writer.write(contentToWrite);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file for the timestamp " + timeStamp, e);
        }
    }
}
