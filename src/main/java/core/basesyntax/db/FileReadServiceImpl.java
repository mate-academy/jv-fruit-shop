package core.basesyntax.db;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReadServiceImpl implements FileReadService {
    @Override
    public List<String> readDataFromReport(String file) {
        File reportFile = new File(file);
        List<String> report;
        try {
            report = Files.readAllLines(reportFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Unable to read data from file " + file, e);
        }
        return report;
    }
}
