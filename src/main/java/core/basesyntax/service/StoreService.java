package core.basesyntax.service;

import java.util.List;

public interface StoreService {
    void toStorage(List<String> data);

    String createReport();
}
