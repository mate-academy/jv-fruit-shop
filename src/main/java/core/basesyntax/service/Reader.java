package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface Reader {
    abstract List<FruitTransaction> read();
}
