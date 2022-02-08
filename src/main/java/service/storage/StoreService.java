package service.storage;

import java.util.List;

public interface StoreService {
    void applyToDb(List<String> dataFromFile);

    String getDbReport();
}
