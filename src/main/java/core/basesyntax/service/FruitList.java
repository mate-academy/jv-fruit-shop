package core.basesyntax.service;

import core.basesyntax.db.FruitTransaction;
import java.util.List;

public interface FruitList {
    List<FruitTransaction> getFruitList(List<FruitTransaction> list);
}
