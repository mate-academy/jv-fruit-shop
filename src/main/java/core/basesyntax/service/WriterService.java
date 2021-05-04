package core.basesyntax.service;

import java.util.Map;

public interface WriterService {
    void writeBalanceOfFruitToFile(Map<String, Integer> balance);
}
