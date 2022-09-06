package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface FruitService {
    List<FruitTransaction> getTransaction(List<String> transaction);
    String createReport(Map<String, Integer> fruits);
}
