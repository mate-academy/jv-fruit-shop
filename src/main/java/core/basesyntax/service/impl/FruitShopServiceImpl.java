package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.OperationStrategy;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final OperationStrategy strategy;

    public FruitShopServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        if (transactions == null || transactions.isEmpty()) {
            throw new RuntimeException("Impossible to process transactions! "
                    + "Transactions array is empty!");
        }
        transactions
                    .forEach(t -> strategy
                            .getOperationService(t.getOperation())
                            .getValueByOperation(t));
        Storage.getMap().entrySet().stream()
                .filter(entry -> entry.getValue() < 0)
                .findAny()
                .ifPresent(entry -> {
                    throw new IllegalArgumentException("Value "
                            + entry.getValue()
                            + " is invalid for fruit "
                            + entry.getKey());
                });
    }
}
