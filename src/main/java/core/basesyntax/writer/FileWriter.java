package core.basesyntax.writer;

import java.util.List;

public interface FileWriter {
    void writeToFile(List<String> reportList, String toFileName);
}
