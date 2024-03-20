package core.basesyntax.services.impl;

import core.basesyntax.exceptions.FileOperationException;
import core.basesyntax.services.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class CvsFileWriter implements FileWriter {
    @Override
    public void write(String data, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filePath))) {
            writer.write(data);
        } catch (IOException e) {
            throw new FileOperationException("Can't write to file ", e);
        }
    }
}
