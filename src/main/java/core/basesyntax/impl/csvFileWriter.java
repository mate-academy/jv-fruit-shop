package core.basesyntax.impl;

import core.basesyntax.service.FileWriter;

import java.io.IOException;
import java.nio.file.Path;

public class csvFileWriter implements FileWriter {
    @Override
    public void write(String report, String filePath) {
        Path path = Path.of(filePath);
        try (java.io.FileWriter fileWriter = new java.io.FileWriter(filePath)) {
            fileWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: "
                    + path.getFileName(), e);
        }
    }
}
