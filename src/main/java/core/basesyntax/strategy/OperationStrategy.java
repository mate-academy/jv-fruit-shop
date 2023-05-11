package core.basesyntax.strategy;

import core.basesyntax.dao.ProductDaoService;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.impl.PlusOperationServiceImpl;
import core.basesyntax.strategy.impl.SubtractOperationServiceImpl;
import java.util.Map;

public class OperationStrategy {
    private final ProductDaoService productDaoService;
    private final Map<FruitTransaction.Operation, OperationService> operationServiceMap;

    public OperationStrategy(ProductDaoService productDaoService) {
        this.productDaoService = productDaoService;
        this.operationServiceMap = createOperationServiceMap();
    }

    public OperationService getOperationBySpecialMark(FruitTransaction transaction) {
        return operationServiceMap.get(transaction.getOperation());
    }

    private Map<FruitTransaction.Operation, OperationService> createOperationServiceMap() {
        return Map.of(
                FruitTransaction.Operation.BALANCE,
                new PlusOperationServiceImpl(productDaoService),
                FruitTransaction.Operation.SUPPLY,
                new PlusOperationServiceImpl(productDaoService),
                FruitTransaction.Operation.RETURN,
                new PlusOperationServiceImpl(productDaoService),
                FruitTransaction.Operation.PURCHASE,
                new SubtractOperationServiceImpl(productDaoService)
        );
    }
}
