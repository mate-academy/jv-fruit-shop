package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.TypeStrategy;
import java.util.Map;

public interface OperationsToMapService {
    Map<FruitTransaction.Operation, TypeStrategy> operationsToMap();
}
