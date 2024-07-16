package core.basesyntax.service;

import core.basesyntax.db.FruitTransaction;
import java.util.List;

public interface DeepCopy {
    List<FruitTransaction> getDeepCopy(List<FruitTransaction> list);
}
