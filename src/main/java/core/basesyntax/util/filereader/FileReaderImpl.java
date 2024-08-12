package core.basesyntax.util.filereader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String fromFileName) {
        Path inputFilePath = Paths.get(fromFileName);
        List<String> lines;
        try {
            lines = Files.readAllLines(inputFilePath);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from a file named: " + fromFileName, e);
        }
        return lines;
    }
}
