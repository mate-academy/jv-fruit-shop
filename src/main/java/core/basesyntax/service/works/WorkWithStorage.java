package core.basesyntax.service.works;

import java.util.List;

public interface WorkWithStorage {
    void writeToStorage(List<String> information);

    String generateReport();
}
