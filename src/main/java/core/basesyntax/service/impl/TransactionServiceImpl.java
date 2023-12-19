package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionServiceImpl implements TransactionService {
    private OperationStrategy operationStrategy;
    private final FruitDao fruitDao;

    public TransactionServiceImpl(OperationStrategy operationStrategy, FruitDao fruitDao) {
        this.operationStrategy = operationStrategy;
        this.fruitDao = fruitDao;
    }

    @Override
    public void processTransactions(List<FruitTransaction> fruits) {
        Map<String, Integer> transactions = fruits.stream()
                .collect(Collectors.groupingBy(FruitTransaction::getFruitName,
                        Collectors.summingInt(fruit ->
                                operationStrategy.get(fruit.getOperation())
                                        .calculate(fruit))));
        for (Map.Entry<String, Integer> entry : transactions.entrySet()) {
            fruitDao.addFruit(entry.getKey(), entry.getValue());
        }
    }
}

