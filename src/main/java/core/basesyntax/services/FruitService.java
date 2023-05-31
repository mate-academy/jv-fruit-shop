package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitService {
    void store(List<FruitTransaction> transactions);
}
