package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.Operation;
import java.util.List;

public class OperationImpl implements Operation {
    private final FruitShopService fruitShopService;

    public OperationImpl(FruitShopService fruitShopService) {
        this.fruitShopService = fruitShopService;
    }

    @Override
    public void calculate(List<FruitTransaction> fruitTransactions) {
        if (fruitTransactions.isEmpty()) {
            throw new RuntimeException("Empty input");
        }
        fruitTransactions.forEach(i -> fruitShopService
                .get(i.getOperation()).apply(i));
    }
}
