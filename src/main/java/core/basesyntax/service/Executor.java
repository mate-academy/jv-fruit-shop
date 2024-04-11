package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface Executor {
    void execute(List<FruitTransaction> fruitTransaction);
}
