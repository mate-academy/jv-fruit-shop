package core.basesyntax.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements MyFileWriter {

    @Override
    public void write(String fileName, String context) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(context);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write data to file: " + fileName, e);
        }
    }
}
