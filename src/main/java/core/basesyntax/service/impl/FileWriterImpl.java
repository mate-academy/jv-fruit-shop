package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(List<String> data, File file) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(file))) {
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't create file", e);
        }
    }
}

