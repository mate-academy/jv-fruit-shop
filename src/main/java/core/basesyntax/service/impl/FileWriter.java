package core.basesyntax.service.impl;

import core.basesyntax.service.IFileWriter;
import java.io.IOException;

public class FileWriter implements IFileWriter {

    @Override
    public void writeToFile(String fileName, String data) {
        try (java.io.FileWriter writer = new java.io.FileWriter(fileName)) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Could not write to file: " + fileName, e);
        }
    }
}
