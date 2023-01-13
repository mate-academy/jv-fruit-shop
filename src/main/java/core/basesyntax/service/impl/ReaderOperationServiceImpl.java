package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderOperationService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReaderOperationServiceImpl implements ReaderOperationService {
    @Override
    public String readDataFromFile(String fromFile) {
        try {
            return Files.readString(Path.of(fromFile));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File " + fromFile + " not found!", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file" + fromFile, e);
        }
    }
}
