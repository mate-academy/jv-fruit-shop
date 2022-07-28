package core.basesyntax.serviceimpl;

import core.basesyntax.service.FileService;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileServiceImpl implements FileService {

    @Override
    public List<String> getFromFile(String filePath) {
        List<String> fromFile = null;
        try {
            fromFile = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Cannot read from this file: " + filePath);
        }
        return fromFile;
    }

    @Override
    public void writeToTheFile(String filePath, List<String> lines) {
        try {
            Files.write(Path.of(filePath), lines, Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException("Cannot write to this file: " + filePath);
        }
    }
}
