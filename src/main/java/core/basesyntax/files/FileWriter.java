package core.basesyntax.files;

import java.util.List;

public interface FileWriter {
    void writeToFile(String toFileName, List<String> lines);
}
