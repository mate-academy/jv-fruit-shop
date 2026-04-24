package core.basesyntax;

import java.util.List;

public interface FileWriter {
    void writeFile(List<String> lines, String path);
}
