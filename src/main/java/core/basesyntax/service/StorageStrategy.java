package core.basesyntax.service;

import java.util.List;

public interface StorageStrategy {
    void saveAll(List<String[]> fruits);
}
