package core.basesyntax.dao.impl;

import core.basesyntax.dao.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String report, String filename) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename))) {
            writer.write(report);
        } catch (NoSuchFileException e) {
            throw new RuntimeException("File not found: " + filename, e);
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while writing to a file: " + filename, e);
        }
    }
}
