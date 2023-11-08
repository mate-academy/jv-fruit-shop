package core.basesyntax.db;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readFile(String fileName) {
        File reportFile = new File(fileName);
        List<String> report;
        try {
            report = Files.readAllLines(reportFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Unable to read data from file " + fileName, e);
        }
        return report;
    }
}
