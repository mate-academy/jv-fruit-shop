package core.basesyntax.fileservice;

import java.util.List;

public interface FileWriter {
    void writeToFile(String filePath, List<String> lines);
}
