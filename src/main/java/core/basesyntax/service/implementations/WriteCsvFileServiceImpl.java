package core.basesyntax.service.implementations;

import core.basesyntax.exceptions.WriteFileException;
import core.basesyntax.service.WriteCsvFileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriteCsvFileServiceImpl implements WriteCsvFileService {
    public void writeFile(String filename, List<String> data) {
        try {
            if (data.isEmpty()) {
                throw new WriteFileException("Writing empty data. You give me " + data);
            }
            if (filename.matches(".*[:\\\\?*|\"<>].*")) {
                throw new WriteFileException("Invalid characters in the filename: " + filename);
            }
            if (filename.contains(" ")) {
                throw new WriteFileException("Filename cannot contain spaces: " + filename);
            }
            Files.write(Path.of(filename), data);
        } catch (IOException e) {
            throw new WriteFileException("Can`t write to file: " + filename);
        }
    }
}
