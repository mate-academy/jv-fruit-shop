package core.basesyntax.impl;

import core.basesyntax.service.WriteService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToCsv implements WriteService {
    @Override
    public void writeToFile(List<String> preparedData, String path) {
        if (path == null || preparedData == null) {
            throw new RuntimeException("Can't write to file with path or data null");
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            for (String data : preparedData) {
                bufferedWriter.write(data + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file with path: " + path);
        }

    }
}
