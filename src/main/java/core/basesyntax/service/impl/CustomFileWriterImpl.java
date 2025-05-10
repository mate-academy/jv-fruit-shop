package core.basesyntax.service.impl;

import core.basesyntax.service.CustomFileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class CustomFileWriterImpl implements CustomFileWriter {
    @Override
    public void write(String data, String path) throws IOException {
        if (data == null || data.trim().isEmpty()) {
            throw new IllegalArgumentException("Data cannot be null or empty.");
        }

        if (path == null || path.trim().isEmpty()) {
            throw new IllegalArgumentException("Path cannot be null or empty.");
        }

        try (BufferedWriter bw = new BufferedWriter(new java.io.FileWriter(path))) {
            bw.write(data);
        } catch (IOException e) {
            throw new IOException("Can't write to file: " + path, e);
        }
    }
}
