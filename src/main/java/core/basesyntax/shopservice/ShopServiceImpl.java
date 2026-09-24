package core.basesyntax.shopservice;

import core.basesyntax.Storage;
import core.basesyntax.fruittransaction.FruitTransaction;
import core.basesyntax.operationstrategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final Storage storage;
    private final OperationStrategy strategy;

    public ShopServiceImpl(Storage storage,OperationStrategy strategy) {
        this.storage = storage;
        this.strategy = strategy;
    }

    public Storage getStorage() {
        return storage;
    }

    @Override
    public void process(List<FruitTransaction> operations) {

    }
}
