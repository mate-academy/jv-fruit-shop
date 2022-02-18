package core.basesyntax.service;

import java.util.List;

public interface DataProcessor {
    void registerTransaction(String line);

    void createFruits(List<String> parsedData);
}
