package core.basesyntax.shopservice;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationstrategy.OperationStrategyService;
import java.util.List;

public class ShopServiceImpl implements ShopService {

    private OperationStrategyService operationStrategyService;

    public ShopServiceImpl(OperationStrategyService operationStrategyService) {
        this.operationStrategyService = operationStrategyService;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {

        fruitTransactions
                .forEach(e -> operationStrategyService
                        .getHandler(e.getTypeOfTransaction()).handle(e));

    }
}
