package storage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    private static final int INDEX_OF_HEAD_ELEMENT = 0;

    public List<String> getInfoFromFile(File file) {
        try {
            List<String> parsedInfo = Files.readAllLines(file.toPath());
            parsedInfo.remove(INDEX_OF_HEAD_ELEMENT);
            return parsedInfo;
        } catch (IOException e) {
            throw new RuntimeException(String.format("Can't read from file %s", file), e);
        }
    }
}
