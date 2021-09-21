package service.storage;

import java.util.List;

public interface StoreService {
    void addToMap(List<String> dataFromFile);

    String getReportFromStorage();
}
