package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface OperationProcess {
    void processData(List<FruitTransaction> transactions);
}
