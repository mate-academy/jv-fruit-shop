package core.basesyntax.service;

import java.util.List;

public interface FileWorkerService {
    List<String> readFromFile(String fileName);

    void createReport(List<String> products);
}
