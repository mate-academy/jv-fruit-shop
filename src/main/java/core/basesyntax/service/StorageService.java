package core.basesyntax.service;

import java.util.List;

public interface StorageService {
    void saveAll(List<String[]> fruits, OperationStrategy operationStrategy);

    void add(String fruit, Integer amount);

    void subtract(String fruit, Integer amount);
}
