package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ShopService;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final Storage storage;

    public ShopServiceImpl(OperationStrategy operationStrategy, Storage storage) {
        if (operationStrategy == null) {
            throw new IllegalArgumentException("Operation can't be null");
        }
        if (storage == null) {
            throw new IllegalArgumentException("Storage can't be null");
        }
        this.operationStrategy = operationStrategy;
        this.storage = storage;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        if (transactions == null) {
            throw new IllegalArgumentException("FruitTransaction can't be null");
        }
        if (transactions.isEmpty()) {
            return;
        }
        for (FruitTransaction tx : transactions) {
            operationStrategy.handle(tx, storage);
        }
    }
}
