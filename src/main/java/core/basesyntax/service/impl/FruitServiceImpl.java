package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    private final OperationStrategy operationStrategy;

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public List<Fruit> getAll(List<FruitTransaction> fruitTransactions) {
        if (fruitTransactions == null) {
            throw new RuntimeException("FruitTransactions cannot be null");
        }
        fruitTransactions.forEach(fruitTransaction -> {
            if (fruitTransaction == null) {
                throw new RuntimeException("FruitTransaction cannot be null");
            }
            if (fruitTransaction.getFruit() == null) {
                throw new RuntimeException("Fruit cannot be null");
            }
            if (fruitTransaction.getFruit().getName() == null) {
                throw new RuntimeException("Fruit name cannot be null");
            }
        });
        Map<String, Integer> fruitBalanceMap = fruitTransactions.stream()
                .collect(Collectors.groupingBy(
                        fruitTransaction -> fruitTransaction.getFruit().getName(),
                        Collectors.mapping(this::calculateQuantityByStrategy,
                                Collectors.summingInt(quantity -> quantity))));

        return fruitBalanceMap.entrySet().stream()
                .map(entry -> new Fruit(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparing(Fruit::getName))
                .collect(Collectors.toList());
    }

    @Override
    public String getFruitsReport() {
        return Storage.fruits.stream()
                .map(fruit -> System.lineSeparator() + fruit.getName() + "," + fruit.getQuantity())
                .reduce("fruit,quantity", (row1, row2) -> row1 + row2);
    }

    private Integer calculateQuantityByStrategy(FruitTransaction fruitTransaction) {
        return operationStrategy
                .getOperationHandler(fruitTransaction.getOperation())
                .getQuantity(fruitTransaction);
    }
}
