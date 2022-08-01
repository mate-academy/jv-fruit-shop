package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface OperationHandler {
    void apply(List<FruitTransaction> transactions);
}
