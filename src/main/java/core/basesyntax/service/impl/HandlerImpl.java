package core.basesyntax.service.impl;

import core.basesyntax.db.dao.StorageDao;
import core.basesyntax.db.dao.impl.StorageDaoImpl;
import core.basesyntax.model.Item;
import core.basesyntax.model.ItemTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.Handler;
import core.basesyntax.strategy.DataOperationStrategy;
import core.basesyntax.strategy.impl.DataOperationStrategyImpl;
import java.util.List;

public class HandlerImpl implements Handler {
    private final DataOperationStrategy dataOperationStrategy = new DataOperationStrategyImpl();

    @Override
    public void handle(List<ItemTransaction> itemTransactions) {
        if (itemTransactions == null) {
            throw new NullPointerException("input is null");
        }
        for (ItemTransaction itemTransaction : itemTransactions) {
            Item item = new Item(itemTransaction.getName(), itemTransaction.getQuantity());
            StorageDao dao = new StorageDaoImpl();
            Operation operation = itemTransaction.getOperation();
            dataOperationStrategy.get(operation).handle(item, dao);
        }
    }
}
