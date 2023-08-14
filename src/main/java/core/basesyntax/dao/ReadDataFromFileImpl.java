package core.basesyntax.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReadDataFromFileImpl implements ReadDataFromFile {
    @Override
    public List<String> getDataFromReport(String file) {
        File reportFile = new File(file);
        List<String> report;
        try {
            report = Files.readAllLines(reportFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + file, e);
        }
        return report;
    }
}
