package core.basesyntax.service;

import java.util.List;

public interface MyFileWriter {
    void writeToFile(String pathToFile, List<String> reportList);
}
