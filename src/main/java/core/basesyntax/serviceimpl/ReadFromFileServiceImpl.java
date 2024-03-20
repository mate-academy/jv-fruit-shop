package core.basesyntax.serviceimpl;

import core.basesyntax.exceptions.InvalidFileException;
import core.basesyntax.service.ReadFromFileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadFromFileServiceImpl implements ReadFromFileService {
    @Override
    public List<String> readFile(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new InvalidFileException("can`t read content from the file");
        }
    }
}
