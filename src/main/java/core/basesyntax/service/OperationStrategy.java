package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface OperationStrategy {
    void doOperation();

    String getReport();
}
