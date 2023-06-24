package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitCalculationService {
    void addToStorage(List<FruitTransaction> transaction);
}
