package serviceimpl;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements service.FileWriter {
    @Override
    public void writeToFile(String report, String toFile) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(report))) {
            writer.write(toFile);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + toFile, e);
        }
    }
}
