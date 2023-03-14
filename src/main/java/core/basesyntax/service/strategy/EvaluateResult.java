package core.basesyntax.service.strategy;

import core.basesyntax.service.model.FruitTransaction;
import java.util.List;

public interface EvaluateResult {
    void realizePattern(List<FruitTransaction> fruitTransactions);
}
