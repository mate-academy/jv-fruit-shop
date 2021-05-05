package core.basesyntax.service;

import java.util.List;

public interface StoreService {
    void processRecords(List<String> data);

    String createReport();
}
