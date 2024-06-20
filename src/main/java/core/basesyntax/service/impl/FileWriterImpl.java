package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String resultingReport, File file) {
        try (BufferedWriter bufferedWriter
                     = new BufferedWriter(new java.io.FileWriter(file))) {
            bufferedWriter.write(resultingReport);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + file, e);
        }

    }
}
