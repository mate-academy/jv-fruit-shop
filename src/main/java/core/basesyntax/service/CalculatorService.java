package core.basesyntax.service;

import core.basesyntax.model.StorageTransaction;
import java.util.List;

public interface CalculatorService {
    void calculate(List<StorageTransaction> transactions);
}
