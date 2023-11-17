package core.basesyntax.handler;

import core.basesyntax.ItemTransaction;
import core.basesyntax.dao.Item;
import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.data.DataOperationStrategy;
import core.basesyntax.data.DataOperationStrategyImpl;
import core.basesyntax.data.Operation;
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
