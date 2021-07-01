package core.basesyntax.service;

import java.util.List;

public interface StoreService {
    void addToStorage(List<String> dataFromFile);

    String getTheReportFromTheStorage();
}
