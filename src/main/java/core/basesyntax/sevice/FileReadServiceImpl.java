package core.basesyntax.sevice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReadServiceImpl implements FileReadService {
    @Override
    public List<String> readDataFromFile(String filePath) {
        File readFrom = new File(filePath);
        try {
            return Files.readAllLines(readFrom.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + readFrom);
        }
    }
}
