package service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterImpl implements Writer {
    private static final String FILE_SEPARATOR = FileSystems.getDefault().getSeparator();
    private static final String OUTPUT_FILE = "src" + FILE_SEPARATOR
            + "main" + FILE_SEPARATOR + "resources" + FILE_SEPARATOR + "output.csv";

    @Override
    public void write(String data) {
        try {
            Files.write(Path.of(OUTPUT_FILE), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + OUTPUT_FILE);
        }
    }
}
