package core.basesyntax.service.impl;

import core.basesyntax.service.WriterToFile;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterToFileImpl implements WriterToFile {
    @Override
    public void writeData(String pathToFile, String report) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(pathToFile, true))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file", e);
        }
    }
}

