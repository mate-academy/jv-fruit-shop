package core.basesyntax.service.implementations;

import core.basesyntax.exceptions.FruitsQuantityException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.DataHandlerStrategy;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private DataHandlerStrategy dataHandlerStrategy;
    private List<FruitTransaction> transactions;

    public FruitShopServiceImpl(
            List<FruitTransaction> transactions, DataHandlerStrategy dataHandlerStrategy) {
        this.dataHandlerStrategy = dataHandlerStrategy;
        this.transactions = transactions;
    }

    // add all information to Storage depending on transactions
    public void updateData() {
        Storage.createMap();
        transactions.forEach(transaction -> {
            int quantity = transaction.getQuantity();
            if (quantity < 0) {
                throw new FruitsQuantityException("Invalid quantity: "
                        + quantity
                        + " for "
                        + transaction.getFruit());
            }
            dataHandlerStrategy.getHandler(transaction.getOperation())
                    .processData(transaction.getFruit(), quantity);
        });
    }
}
