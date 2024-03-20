package core.basesyntax.service.storage;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.repository.Storage;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.StrategySupplier;
import java.util.List;

public class StorageServiceImpl implements StorageService {
    private final Storage storage;
    private final StrategySupplier changesStrategy;

    public StorageServiceImpl(Storage storage, StrategySupplier changesStrategy) {
        this.storage = storage;
        this.changesStrategy = changesStrategy;
    }

    @Override
    public void transfer(List<FruitTransaction> fruits) {
        for (FruitTransaction fruit : fruits) {
            Strategy chooseStrategy = changesStrategy.getStrategy(fruit.operation());
            storage.add(fruit.fruitName(), chooseStrategy.calculateFruitQuantity(
                    storage.getQuantity(fruit.fruitName()), fruit.quantity()));
        }
    }
}
