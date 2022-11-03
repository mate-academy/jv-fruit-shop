package fruitshop.service.impl;

import fruitshop.dao.FruitShopStorageDaoImpl;
import fruitshop.model.FruitReport;
import fruitshop.model.FruitTransaction;
import fruitshop.service.TransactionsCalculatorService;
import fruitshop.strategy.operation.impl.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionsCalculatorServiceImpl implements TransactionsCalculatorService {
    private final OperationStrategyImpl operationStrategy;
    private final FruitShopStorageDaoImpl storageDao;

    public TransactionsCalculatorServiceImpl(
            OperationStrategyImpl operationStrategy,
            FruitShopStorageDaoImpl storageDao
    ) {
        this.operationStrategy = operationStrategy;
        this.storageDao = storageDao;
    }

    public List<FruitReport> calculate() {
        Map<String, Integer> processed = new HashMap<>();
        for (FruitTransaction transaction : storageDao.getAll()) {
            Integer previousQuantity = processed.get(transaction.getFruitName());
            if (previousQuantity == null) {
                processed.put(transaction.getFruitName(), transaction.getQuantity());
            } else {
                processed.put(transaction.getFruitName(),
                        operationStrategy
                                .getHandler(transaction.getOperation())
                                .handle(previousQuantity, transaction.getQuantity())
                );
            }
        }
        return processed
                .entrySet()
                .stream()
                .map(e -> new FruitReport(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }
}
