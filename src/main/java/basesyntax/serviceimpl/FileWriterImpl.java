package basesyntax.serviceimpl;

import basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String data, String path) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(path))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to file: " + path, e);
        }
    }
}
