package core.basesyntax.service.implementations;

import core.basesyntax.exceptions.ReadFileException;
import core.basesyntax.service.ReadCsvFileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadCsvFileServiceImpl implements ReadCsvFileService {
    @Override
    public List<String> readFile(String filename) {
        List<String> data;
        try {
            if (filename == null) {
                throw new ReadFileException("How did you dare to give null filename?");
            }
            data = Files.readAllLines(Path.of(filename));
        } catch (IOException e) {
            throw new ReadFileException("Can`t read from file: " + filename, e);
        }
        return data;
    }
}
