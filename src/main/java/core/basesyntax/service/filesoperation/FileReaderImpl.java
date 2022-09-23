package core.basesyntax.service.filesoperation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private static final String ERROR_READ_MESSAGE = "Can't find file by path: ";
    private List<String> frits;

    @Override
    public List<String> read(String filePath) {
        try {
            frits = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException(ERROR_READ_MESSAGE + filePath);
        }
        return frits;
    }
}
