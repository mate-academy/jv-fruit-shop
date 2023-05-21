package core.basesyntax.strategy;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.impl.BalanceOperationServiceImpl;
import core.basesyntax.strategy.impl.PurchaseOperationServiceImpl;
import core.basesyntax.strategy.impl.ReturnOperationServiceImpl;
import core.basesyntax.strategy.impl.SupplyOperationServiceImpl;
import java.util.Map;

public class OperationStrategy {
    private final ProductDao productDaoService;
    private final Map<FruitTransaction.Operation, OperationService> operationServiceMap;

    public OperationStrategy(ProductDao productDaoService) {
        this.productDaoService = productDaoService;
        this.operationServiceMap = createOperationServiceMap();
    }

    public OperationService getOperation(FruitTransaction transaction) {
        return operationServiceMap.get(transaction.getOperation());
    }

    private Map<FruitTransaction.Operation, OperationService> createOperationServiceMap() {
        return Map.of(
                FruitTransaction.Operation.BALANCE,
                new BalanceOperationServiceImpl(productDaoService),
                FruitTransaction.Operation.SUPPLY,
                new SupplyOperationServiceImpl(productDaoService),
                FruitTransaction.Operation.RETURN,
                new ReturnOperationServiceImpl(productDaoService),
                FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationServiceImpl(productDaoService)
        );
    }
}
