package core.basesyntax.service.impl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    private BufferedWriter writer;

    public void writeToFile(String pathToFile, String data) {
        {
            try {
                writer = Files.newBufferedWriter(Path.of(pathToFile));
                writer.write(data);
                writer.flush();
            } catch (IOException e) {
                throw new RuntimeException("Can't write to file", e);
            }
        }
    }
}
