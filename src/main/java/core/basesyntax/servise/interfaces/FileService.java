package core.basesyntax.servise;

import java.util.List;

public interface FileService {
    List<String> readFromFile(String fromFileName);

    void createReportFile(String report);
}
