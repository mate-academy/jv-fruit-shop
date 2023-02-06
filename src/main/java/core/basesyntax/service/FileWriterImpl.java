package core.basesyntax.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class FileWriterImpl implements FileWriter {

    @Override
    public void writeToFile(String report, String filepath) {
        File outputFile = new File(filepath);
        try {
            Files.write(outputFile.toPath(), report.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("Can't write to the file: " + filepath, e);
        }
    }
}
