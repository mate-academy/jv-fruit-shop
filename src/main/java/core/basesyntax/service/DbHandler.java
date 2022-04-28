package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DbHandler {
    void proceed(List<FruitTransaction> transactions);
}
