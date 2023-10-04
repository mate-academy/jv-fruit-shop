package core.basesyntax.service.implementations;

import core.basesyntax.exceptions.FruitsQuantityException;
import core.basesyntax.exceptions.TransactionException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.strategy.DataHandlerStrategy;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final DataHandlerStrategy dataHandlerStrategy;

    public FruitShopServiceImpl(DataHandlerStrategy dataHandlerStrategy) {
        this.dataHandlerStrategy = dataHandlerStrategy;
    }

    /**
     * Add data to storage depending on transaction fields
     **/
    public void updateData(List<FruitTransaction> transactions) {
        validateTransactionData(transactions);
        transactions.forEach(transaction -> {
            int quantity = transaction.getQuantity();
            validateQuantityData(quantity);
            dataHandlerStrategy.getHandler(transaction.getOperation())
                    .processData(transaction.getFruit(), quantity);
        });
    }

    public void validateTransactionData(List<FruitTransaction> transactions) {
        if (transactions == null) {
            throw new TransactionException("Null transactions on input");
        }
    }

    public void validateQuantityData(int quantity) {
        if (quantity < 0) {
            throw new FruitsQuantityException("Invalid quantity: "
                    + quantity);
        }
    }
}
