package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileWriterServiceImpl implements FileWriterService {
    public static final String FILE_HEADER = "fruit,quantity";

    @Override
    public void fileWriterCsv(List<String> fruitCount, String path) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(path))) {
            bufferedWriter.write(FILE_HEADER);
            bufferedWriter.newLine();
            for (String fruitTransact : fruitCount) {
                bufferedWriter.write(fruitTransact);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file: " + path, e);
        }
    }
}
