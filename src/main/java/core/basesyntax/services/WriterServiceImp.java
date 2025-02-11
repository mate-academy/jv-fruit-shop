package core.basesyntax.services;

import core.basesyntax.exceptions.WriteDataToFileException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterServiceImp implements WriterService {
    private static final String HEADER = "fruit,quantity";

    @Override
    public void write(String filePath, List<String> data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(HEADER);
            bufferedWriter.newLine();
            for (String line : data) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new WriteDataToFileException("Can't write data to file: " + filePath);
        }
    }
}
