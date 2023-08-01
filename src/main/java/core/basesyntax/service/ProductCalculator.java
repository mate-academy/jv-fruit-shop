package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ProductCalculator {
    void calculateProducts(List<FruitTransaction> transactions);
}
