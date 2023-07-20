package core.basesyntax.service;

import java.util.Map;

public interface FruitTransactionService {
    Map<String, Integer> getReport(String fileName);
}
