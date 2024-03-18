package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileWriterService implements WriterService {
    @Override
    public void writeData(String filePath, List<String> data) {
        try (var br = Files.newBufferedWriter(
                Paths.get(filePath),
                StandardCharsets.UTF_8)
        ) {
            for (String datum : data) {
                br.write(datum);
                br.newLine();
            }
        } catch (IOException ex) {
            throw new RuntimeException(
                    String.format("Can`t write data to the file ", filePath),
                    ex
            );
        }
    }
}
