package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.performers.BalanceOperationPerformer;
import core.basesyntax.strategy.performers.PurchaseOperationPerformer;
import core.basesyntax.strategy.performers.ReturnOperationPerformer;
import core.basesyntax.strategy.performers.SupplyOperationPerformer;
import java.util.HashMap;
import java.util.Map;

public class OperationPerformerStrategyImpl implements OperationPerformerStrategy {
    private static final Map<FruitTransaction.Operation, OperationPerformer> performers;
    private static StorageDao dao = new StorageDaoImpl();

    static {
        performers = new HashMap<>();
        performers.put(FruitTransaction.Operation.BALANCE, new BalanceOperationPerformer(dao));
        performers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationPerformer(dao));
        performers.put(FruitTransaction.Operation.RETURN, new ReturnOperationPerformer(dao));
        performers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationPerformer(dao));
    }

    @Override
    public OperationPerformer getOperationPerformer(FruitTransaction.Operation operation) {
        return performers.get(operation);
    }
}
