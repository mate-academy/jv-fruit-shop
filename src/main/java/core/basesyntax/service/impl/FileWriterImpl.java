package core.basesyntax.service.impl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    private String path;
    private BufferedWriter writer;

    public FileWriterImpl(String path) {
        this.path = path;
    }

    public void writeToFile() {
        {
            try {
                writer = Files.newBufferedWriter(Path.of(path));
                writer.write(new ReportCreatorImpl().createReport());
                writer.flush();
            } catch (IOException e) {
                throw new RuntimeException("Can't write to file", e);
            }
        }
    }
}
