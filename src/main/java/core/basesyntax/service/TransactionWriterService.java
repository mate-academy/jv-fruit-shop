package core.basesyntax.service;

import java.util.Map;

public interface TransactionWriterService {
    void writeToFile(Map<String, Integer> fruitReport, String fileName);
}
