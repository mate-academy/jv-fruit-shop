package core.basesyntax.shopservice;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationstrategy.OperationStrategyService;
import java.util.List;

public class ShopServiceImpl implements ShopService {

    private final OperationStrategyService operationStrategyService;

    public ShopServiceImpl(OperationStrategyService operationStrategyService) {
        this.operationStrategyService = operationStrategyService;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        if (fruitTransactions == null) {
            throw new RuntimeException("The list doesn't exist.");
        }
        fruitTransactions
                .forEach(e -> operationStrategyService
                        .getHandler(e.getTypeOfTransaction()).handle(e));

    }
}
