package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String data, String path) {
        try (BufferedWriter bw = new BufferedWriter(new java.io.FileWriter(path))) {
            bw.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + path, e);
        }
    }
}
