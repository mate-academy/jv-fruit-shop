package core.basesyntax.service.fileservice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String inputFileName) {
        List<String> inputReport;
        try {
            inputReport = Files.readAllLines(Path.of(inputFileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + inputFileName);
        }
        return inputReport;
    }
}
