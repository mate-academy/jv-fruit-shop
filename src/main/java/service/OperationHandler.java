package service;

import core.basesyntax.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface OperationHandler {
    Map<String, Integer> update(List<FruitTransaction> data);
}
