package core.basesyntax.service.implementations;

import core.basesyntax.exceptions.WriteFileException;
import core.basesyntax.service.WriteCsvFileService;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class WriteCsvFileServiceImpl implements WriteCsvFileService {

    public void writeFile(String filename, String data) {
        try {
            validateNullData(data);
            Files.write(Path.of(filename), data.getBytes(StandardCharsets.UTF_8));
        } catch (InvalidPathException e) {
            throw new WriteFileException(
                    "Can`t write to file with name: " + filename, e);
        } catch (IOException e) {
            throw new WriteFileException("Can`t write to file: " + filename, e);
        }
    }

    public void validateNullData(String data) {
        if (data == null) {
            throw new WriteFileException("Writing null data. You give me " + data);
        }
    }
}
