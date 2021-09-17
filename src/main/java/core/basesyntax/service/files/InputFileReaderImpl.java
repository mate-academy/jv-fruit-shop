package core.basesyntax.service.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class InputFileReaderImpl implements InputFileReader {
    private static final int HEADER_LINE_INDEX = 0;

    @Override
    public List<String> readFile(String fileName) {
        List<String> result;
        try {
            result = Files.readAllLines(Paths.get(fileName));
            result.remove(HEADER_LINE_INDEX);
        } catch (IOException e) {
            throw new RuntimeException("Can't read input file, " + e);
        }
        return result;
    }
}
