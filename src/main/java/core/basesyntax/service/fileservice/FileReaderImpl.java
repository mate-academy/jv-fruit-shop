package core.basesyntax.service.fileservice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private static final int HEADER_INDEX_TO_REMOVE = 0;

    @Override
    public List<String> read(String inputFileName) {
        List<String> inputReport;
        try {
            inputReport = Files.readAllLines(Path.of(inputFileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + inputFileName);
        }
        inputReport.remove(HEADER_INDEX_TO_REMOVE);
        return inputReport;
    }
}
