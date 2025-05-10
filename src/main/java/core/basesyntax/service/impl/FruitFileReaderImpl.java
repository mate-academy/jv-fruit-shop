package core.basesyntax.service.impl;

import core.basesyntax.exception.NoFileToReadException;
import core.basesyntax.service.interfaces.FruitFileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FruitFileReaderImpl implements FruitFileReader {
    private CheckFilePathImpl filePathExist = new CheckFilePathImpl();

    @Override
    public List<String> readFile(String filePath) {
        if (filePathExist.checkFilePath(filePath)) {
            throw new NoFileToReadException("File path is empty cannot read data");
        }
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new NoFileToReadException("Cannot read from file" + e.getMessage());
        }
    }
}
