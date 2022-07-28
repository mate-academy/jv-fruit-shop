package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface DataProcessing {
    List<String> getReport(Map<String, List<FruitTransaction>> fruits);
}
