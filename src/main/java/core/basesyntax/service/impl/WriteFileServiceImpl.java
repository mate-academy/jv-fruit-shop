package core.basesyntax.service.impl;

import core.basesyntax.service.WriteFileService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class WriteFileServiceImpl implements WriteFileService {
    private static final String FILE_HEADER = "fruit,quantity" + System.lineSeparator();

    @Override
    public void writeToFile(Path path, String data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(path.toString(), false))) {
            bufferedWriter.write(FILE_HEADER);
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException(
                    String.format("Can`t write data: %s ,to file %s", data, path));
        }
    }
}
