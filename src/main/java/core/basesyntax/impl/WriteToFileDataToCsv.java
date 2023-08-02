package core.basesyntax.impl;

import core.basesyntax.service.WriteDataToFileService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileDataToCsv implements WriteDataToFileService {
    @Override
    public void writeToFile(String preparedData, String path) {
        if (preparedData == null) {
            throw new RuntimeException("Can't write to file null data");
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(preparedData);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file with path: " + path);
        }
    }
}
