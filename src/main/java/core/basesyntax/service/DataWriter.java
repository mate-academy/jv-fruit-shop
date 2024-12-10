package core.basesyntax.service;

import java.util.List;

public interface DataWriter {
    void writeToFile(List<String> report, String filename);
}
