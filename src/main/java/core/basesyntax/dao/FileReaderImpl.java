package core.basesyntax.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements MyFileReader {
    private List<String> inputReport = new ArrayList<>();

    @Override
    public List<String> read(String fileName) {
        try {
            inputReport = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Cant get data from file" + fileName, e);
        }
        return inputReport;
    }
}
