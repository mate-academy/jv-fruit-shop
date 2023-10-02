package core.basesyntax.service.fileservices;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readFromCsvFile(String filePath) {
        List<String> listOfFruits;
        try {
            listOfFruits = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + filePath, e);
        }
        return listOfFruits;
    }
}
