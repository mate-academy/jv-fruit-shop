package core.basesyntax.service.io;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(String pathToFile, String data) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new java.io.FileWriter(pathToFile))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can not write to file: " + pathToFile, e);
        }
    }
}
