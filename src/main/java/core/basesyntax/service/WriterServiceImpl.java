package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterServiceImpl implements WriterService {

    @Override
    public void writeToFile(List<String> data, String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            for (String row : data) {
                bufferedWriter.write(row);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to path " + filePath);
        }
    }
}
