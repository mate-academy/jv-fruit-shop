package core.basesyntax.strategy.performers;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationPerformer;

public class PurchaseOperationPerformer implements OperationPerformer {
    private StorageDao dao;

    public PurchaseOperationPerformer(StorageDao dao) {
        this.dao = dao;
    }

    @Override
    public void perform(FruitTransaction transaction) {
        int quantity = transaction.getQuantity();
        Fruit fruit = transaction.getFruit();
        int storedQuantity = dao.get(fruit);
        if (storedQuantity < quantity) {
            throw new RuntimeException(String.format("Not enough {}, stored={}, needed={}",
                    fruit, storedQuantity, quantity));
        }
        dao.reduce(transaction.getFruit(), transaction.getQuantity());
    }
}
