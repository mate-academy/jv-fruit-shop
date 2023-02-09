package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {

    @Override
    public void write(String report, String fileName) {
        try (java.io.FileWriter writer = new java.io.FileWriter(fileName, false)) {
            writer.write(report);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Can't write file " + fileName);
        }
    }
}
