package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitBalanceService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ShopService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;
    private FruitBalanceService fruitBalanceService;

    public ShopServiceImpl(OperationStrategy operationStrategy,
                           FruitBalanceService fruitBalanceService) {
        this.fruitBalanceService = fruitBalanceService;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        Map<String, Integer> calculatedBalanceMap = transactions.stream()
                .collect(Collectors.groupingBy(FruitTransaction::getFruit, Collectors.summingInt(
                        t -> operationStrategy.get(t.getOperation())
                                .getOperationType(t.getQuantity()))));
        calculatedBalanceMap.forEach(fruitBalanceService::updateFruitBalance);
    }
}
