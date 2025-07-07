package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void fileWriterCsv(String path, String content) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(path))) {
            bufferedWriter.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file: " + path, e);
        }
    }
}
