package core.basesyntax.service;

import java.util.List;

public interface FruitService {
    void writeToStorage(List<String> information);

    String generateReport();
}
