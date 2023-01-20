package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitDaoService {
    void add(List<FruitTransaction> transaction);

    List<FruitTransaction> get();
}
