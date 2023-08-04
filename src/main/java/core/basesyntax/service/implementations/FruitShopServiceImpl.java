package core.basesyntax.service.implementations;

import core.basesyntax.exceptions.FruitsQuantityException;
import core.basesyntax.exceptions.WrongDataBaseException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.DataHandlerStrategy;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final DataHandlerStrategy dataHandlerStrategy;

    public FruitShopServiceImpl(DataHandlerStrategy dataHandlerStrategy) {
        this.dataHandlerStrategy = dataHandlerStrategy;
    }

    // add all information to Storage depending on transactions
    public void updateData(List<FruitTransaction> transactions) {
        if (transactions == null) {
            throw new WrongDataBaseException("Null transactions on input");
        }
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
