package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface Distributor {
    void distribute(List<FruitTransaction> list);
}
