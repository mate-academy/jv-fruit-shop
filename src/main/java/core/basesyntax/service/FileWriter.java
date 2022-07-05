package core.basesyntax.service;

import java.util.List;

public interface FileWriter {
    void writeToFile(String dayReportFilePath, List<String> lines);
}
