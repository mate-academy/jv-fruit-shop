package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class FileWriterServiceImpl implements FileWriterService {
    private static final String FILE_HEADER = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public void fileWriterCsv(String path) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(path))) {
            bufferedWriter.write(FILE_HEADER);
            bufferedWriter.newLine();
            for (Map.Entry<String, Integer> entry: Storage.STORAGE.entrySet()) {
                bufferedWriter.write(entry.getKey() + COMMA + entry.getValue());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file: " + path, e);
        }
    }
}
