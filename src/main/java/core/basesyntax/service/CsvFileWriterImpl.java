package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.IOException;

public class CsvFileWriterImpl implements FileWriter {

    @Override
    public void writeToFile(String report, String filepath) {
        try {
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filepath));
            writer.append(report);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't write to a file" + filepath, e);
        }
    }
}
