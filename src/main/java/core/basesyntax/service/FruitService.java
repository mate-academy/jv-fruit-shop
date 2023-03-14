package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitService {
    void add(FruitTransaction transaction);

    List<FruitTransaction> get(String fileName);

    void update(List<FruitTransaction> transactions);
}
