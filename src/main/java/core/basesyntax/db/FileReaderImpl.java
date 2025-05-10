package core.basesyntax.db;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String fileName) {
        Path inputFile = Paths.get(fileName);
        try {
            if (fileName.isEmpty()) {
                throw new FileNotFoundException("The file path is empty,"
                        + " please provide a file name");
            }
            if (!inputFile.getParent().toFile().exists()) {
                throw new FileNotFoundException("The directory of input file not found: "
                        + fileName);
            }
            if (!Files.exists(inputFile)) {
                throw new FileNotFoundException("File not found: " + fileName);
            }
            return Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Something is wrong with reading file, "
                    + "see description below.",e);
        }
    }
}
