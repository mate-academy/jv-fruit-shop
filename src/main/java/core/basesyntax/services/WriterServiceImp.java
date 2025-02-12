package core.basesyntax.services;

import core.basesyntax.exceptions.WriteDataToFileException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImp implements WriterService {
    private static final String HEADER = "fruit,quantity";

    @Override
    public void write(String filePath, String data) {
        if (filePath == null || data == null) {
            throw new IllegalArgumentException("File path or data cannot be null");
        }

        if (data.isEmpty()) {
            throw new IllegalArgumentException("Data cannot be empty");
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(HEADER);
            bufferedWriter.newLine();

            String[] lines = data.split(System.lineSeparator());
            for (String line : lines) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new WriteDataToFileException("Can't write data to file: " + filePath);
        }
    }
}
