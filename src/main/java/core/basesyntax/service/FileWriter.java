package core.basesyntax.service;

import java.util.List;

public interface FileWriter {
    void writeReport(String targetFileName, List<String> report);
}
