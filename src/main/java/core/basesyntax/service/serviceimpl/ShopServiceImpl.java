package core.basesyntax.service.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.stategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy1) {
        this.operationStrategy = operationStrategy1;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction fruitTransaction : transactions) {
            operationStrategy
                    .getOperation(fruitTransaction.getOperation())
                    .process(fruitTransaction);
        }
    }
}
