package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private final OperationStrategy strategyHandler;

    public FruitServiceImpl(OperationStrategy strategyHandler) {
        this.strategyHandler = strategyHandler;
    }

    @Override
    public Map<String,Integer> process(List<FruitTransaction> transactions) {
        for (FruitTransaction fruit : transactions) {
            strategyHandler.getStrategy(fruit.getOperation()).handleTransaction(fruit);
        }
        return Storage.getStorageFruit();
    }
}
