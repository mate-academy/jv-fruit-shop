package core.basesyntax.service.implementation;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String fileName) {
        List<String> listOfLines;
        try {
            listOfLines = Files.readAllLines(Path.of(fileName));
            return listOfLines;
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from " + fileName, e);
        }
    }
}
