package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitService {
    public void calculateTotalQuantity(List<FruitTransaction> transactions);
}
