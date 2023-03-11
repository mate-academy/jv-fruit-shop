package core.basesyntax.service;

import core.basesyntax.model.StorageTransaction;
import java.util.List;

public interface CalculateService {
    void calculate(List<StorageTransaction> transactions);
}
