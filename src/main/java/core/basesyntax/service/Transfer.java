package core.basesyntax.service;

import core.basesyntax.strategy.OperationStrategy;

public interface Transfer {

    void generateInfo(String[] info, OperationStrategy operationStrategy);
}
