package core.basesyntax.service.impl;

import core.basesyntax.db.FruitDb;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CheckDataService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private final OperationStrategy operationStrategy;
    private final CheckDataService checkDataService;

    public FruitShopServiceImpl(
            OperationStrategy operationStrategy,
            CheckDataService checkDataService) {
        this.operationStrategy = operationStrategy;
        this.checkDataService = checkDataService;
    }

    @Override
    public void executeTransactions(List<FruitTransaction> fruitTransactionList) {
        Map<String, Integer> dayReportMap = new HashMap<>();

        for (FruitTransaction transaction : fruitTransactionList) {
            OperationHandler operationHandlerForTransaction =
                    operationStrategy.get(transaction.getOperation());
            Integer quantityIncludingTransaction = operationHandlerForTransaction
                    .getQuantity(transaction.getQuantity(),
                            transaction.getFruitName(),
                            dayReportMap);

            dayReportMap.put(transaction.getFruitName(), quantityIncludingTransaction);
        }

        checkDataService.checkReport(dayReportMap);

        FruitDb.setBalanceMap(dayReportMap);
    }
}
