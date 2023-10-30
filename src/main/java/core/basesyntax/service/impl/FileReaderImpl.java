package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> readFile(String inputFileName) {
        try {
            return Files.readAllLines(Path.of(inputFileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file "
                    + inputFileName + " !", e);
        }
    }
}
