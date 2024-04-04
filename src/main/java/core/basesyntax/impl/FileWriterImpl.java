package core.basesyntax.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String path, String content) {
        File file = new File(path);
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(file))) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + path);
        }
    }
}
