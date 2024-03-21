package core.basesyntax.service;

import java.io.File;
import java.util.List;

public interface FileWriter {
    void writeToFile(List<String> report, File file);
}
