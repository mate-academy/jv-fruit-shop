package core.basesyntax.service.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private String inputDataFilePath;

    public FileReaderImpl(String inputDataFilePath) {
        this.inputDataFilePath = inputDataFilePath;
    }

    @Override
    public List<String> read() {
        File file = new File(inputDataFilePath);
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("can't read file data");
        }
    }
}
