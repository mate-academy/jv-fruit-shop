package core.basesyntax.report;

import java.util.List;

public interface FileWriter {
    void writeToFile(List<String> reportList, String toFileName);
}
