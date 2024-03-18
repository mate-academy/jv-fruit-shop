package db;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileReaderImpl implements FileReader {
    @Override
    public String read(String fileName) {
        try {
            return Files.readString(new File(fileName).toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + fileName, e);
        }
    }
}
