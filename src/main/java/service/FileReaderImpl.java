package service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private static final int HEADER_INDEX = 0;

    @Override
    public List<String> read(String filePath) {
        List<String> fileContent;
        File file = new File(filePath);
        try {
            fileContent = Files.readAllLines(file.toPath());
            fileContent.remove(HEADER_INDEX);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file!", e);
        }
        return fileContent;
    }
}
