package core.basesyntax.service;

import java.util.List;

public interface WarehouseService {
    void addToStorage(List<String> dataFromFile);

    String getReportFromStorage();
}
