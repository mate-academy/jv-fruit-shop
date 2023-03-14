package core.basesyntax.service.strategy;

import core.basesyntax.service.model.FruitTransaction;
import core.basesyntax.service.operation.FruitService;
import java.util.List;

public class EvaluateResultImpl implements EvaluateResult {
    private final Strategy strategy;

    public EvaluateResultImpl(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void realizePattern(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            FruitService service = strategy.choosePattern(fruitTransaction);
            service.apply(fruitTransaction);
        }
    }
}
