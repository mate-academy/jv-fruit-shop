package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvFileWriter implements FileWriter {
    @Override
    public void writeTextToFile(String fileName, String text) {
        try {
            Files.write(Path.of(fileName), text.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("Cant write data to file" + text, e);
        }
    }
}
