package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationPerformer;
import core.basesyntax.strategy.performers.BalanceOperationPerformer;
import core.basesyntax.strategy.performers.PurchaseOperationPerformer;
import core.basesyntax.strategy.performers.ReturnOperationPerformer;
import core.basesyntax.strategy.performers.SupplyOperationPerformer;
import java.util.HashMap;
import java.util.Map;

public class MapInitializer {
    private StorageDao dao;

    public MapInitializer(StorageDao dao) {
        this.dao = dao;
    }

    public Map<FruitTransaction.Operation, OperationPerformer> initMap() {
        Map<FruitTransaction.Operation, OperationPerformer> performers = new HashMap<>();
        performers.put(FruitTransaction.Operation.BALANCE, new BalanceOperationPerformer(dao));
        performers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationPerformer(dao));
        performers.put(FruitTransaction.Operation.RETURN, new ReturnOperationPerformer(dao));
        performers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationPerformer(dao));
        return performers;
    }
}
