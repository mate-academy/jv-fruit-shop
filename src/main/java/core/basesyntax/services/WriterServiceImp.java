package core.basesyntax.services;

import core.basesyntax.exceptions.WriteDataToFileException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImp implements WriterService {
    @Override
    public void write(String filePath, String data) {
        if (filePath == null || data == null) {
            throw new IllegalArgumentException("File path or data cannot be null");
        }

        if (data.isEmpty()) {
            throw new IllegalArgumentException("Data cannot be empty");
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new WriteDataToFileException("Can't write data to file: " + filePath);
        }
    }
}
