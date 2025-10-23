package core.basesyntax.service.shop;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.FruitTransactionStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final FruitTransactionStrategy fruitTransactionStrategy;

    public ShopServiceImpl(FruitTransactionStrategy fruitTransactionStrategy) {
        if (fruitTransactionStrategy == null) {
            throw new RuntimeException("FruitTransactionStrategy must not be null");
        }
        this.fruitTransactionStrategy = fruitTransactionStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        if (fruitTransactions == null) {
            throw new RuntimeException("Transactions list must not be null");
        }
        if (fruitTransactions.isEmpty()) {
            throw new RuntimeException("Transactions list must not be empty");
        }
        for (FruitTransaction f : fruitTransactions) {
            if (f.getOperation() != null && !f.getFruit().isBlank() && f.getQuantity() >= 0) {
                fruitTransactionStrategy.get(f.getOperation()).handler(f);
            } else {
                throw new RuntimeException(
                        "Incorrect entry in CSV: "
                                +
                                "operation=" + f.getOperation()
                                +
                                ", "
                                +
                                "fruit=" + f.getFruit()
                                +
                                ", "
                                +
                                "quantity=" + f.getQuantity()
                );
            }
        }
    }
}

