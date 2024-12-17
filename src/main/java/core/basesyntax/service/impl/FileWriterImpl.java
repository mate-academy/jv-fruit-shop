package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {

    private final File file;

    public FileWriterImpl(String fileName) {
        this.file = new File(fileName);
    }

    @Override
    public void write(String report, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(file))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("can't save report", e);
        }
    }
}
