package core.basesyntax.service.impl;

import core.basesyntax.service.WriteFileService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileServiceImpl implements WriteFileService {
    private static final String FILE_HEADER = "fruit,quantity" + System.lineSeparator();

    @Override
    public void writeToFile(String path, String data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(path, false))) {
            bufferedWriter.write(FILE_HEADER);
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException(
                    String.format("Can`t write data: %s ,to file %s", data, path));
        }
    }
}
