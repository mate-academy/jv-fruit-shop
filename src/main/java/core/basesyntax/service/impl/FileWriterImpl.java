package core.basesyntax.service.impl;

import core.basesyntax.service.interfaces.FileWriterInterface;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriterInterface {

    @Override
    public void recordDataToFile(String destinationFile, String data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destinationFile))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Unable to record data in file" + destinationFile);
        }
    }
}
