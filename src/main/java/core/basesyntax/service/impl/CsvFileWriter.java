package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CsvFileWriter implements FileWriter {
    @Override
    public void writeData(String filePath, String data) {
        try (var br = Files.newBufferedWriter(
                Paths.get(filePath),
                StandardCharsets.UTF_8)
        ) {
            br.write(data);
        } catch (IOException ex) {
            throw new RuntimeException(
                    String.format("Can`t write data to the file %s", filePath),
                    ex
            );
        }
    }
}
