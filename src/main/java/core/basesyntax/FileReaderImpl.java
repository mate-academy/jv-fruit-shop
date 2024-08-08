package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String fromFileName) {
        File file = new File(fromFileName);
        Path inputFilePath = Path.of(file.toURI());
        List<String> lines;
        try {
            lines = Files.readAllLines(inputFilePath);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from a file named: " + fromFileName, e);
        }
        return lines;
    }
}
