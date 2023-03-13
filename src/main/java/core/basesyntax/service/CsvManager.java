package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;
import java.util.Map;

public interface CsvManager {
    List<Transaction> read(String path);

    void report(Map<String, Integer> report, String path);
}
