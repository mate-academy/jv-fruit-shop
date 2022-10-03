package core.basesyntax.service;

import java.util.List;

public interface FruitService {
    String generateReport();

    void addToStorage(final List<String> transactions);
}
