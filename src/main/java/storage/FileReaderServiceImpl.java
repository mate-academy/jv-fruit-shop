package storage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    private static final File FILE_INPUT = new File("src/main/resources/input.csv");
    private static final Path PATH_OF_FILE = FILE_INPUT.toPath();

    public List<String> getInfoFromFile() {
        try {
            List<String> parsedInfo = Files.readAllLines(PATH_OF_FILE);
            parsedInfo.remove(0);
            return parsedInfo;
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
    }
}
