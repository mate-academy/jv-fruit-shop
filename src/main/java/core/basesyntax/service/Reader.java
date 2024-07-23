package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface Reader {
    List<FruitTransaction> read(String path);
}
