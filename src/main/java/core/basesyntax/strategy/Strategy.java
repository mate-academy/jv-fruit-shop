package core.basesyntax.strategy;

import core.basesyntax.service.CalculateOperation;

public interface Strategy {
    CalculateOperation get(String operation);
}
