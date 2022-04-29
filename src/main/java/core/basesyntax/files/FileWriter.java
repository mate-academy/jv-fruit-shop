package core.basesyntax.files;

import java.util.List;

public interface FileWriter {
    void writeToFile(List<String> lines, String toFileName);
}
