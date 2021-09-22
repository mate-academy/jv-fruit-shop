package core.basesyntax.service.impl;

import core.basesyntax.service.interfaces.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {

    @Override
    public void write(String destinationFile, String data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new java.io.FileWriter(destinationFile))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Unable to record data in file" + destinationFile);
        }
    }
}
