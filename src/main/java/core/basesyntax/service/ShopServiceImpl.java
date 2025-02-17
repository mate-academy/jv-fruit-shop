package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Optional;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        transactions
                .forEach(transaction -> Optional.ofNullable(operationStrategy
                                .getHandler(transaction.getOperation()))
                        .orElseThrow(() -> new RuntimeException("No handler found for operation: "
                                + transaction))
                        .apply(transaction, Storage.getStorage()));
    }
}
