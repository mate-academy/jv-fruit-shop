package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.QuantityStrategy;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    private final QuantityStrategy quantityStrategy;

    public FruitServiceImpl(QuantityStrategy quantityStrategy) {
        this.quantityStrategy = quantityStrategy;
    }

    @Override
    public List<Fruit> getFruitBalance() {
        Storage.fruitTransactions.forEach(fruitTransaction -> {
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
        Map<String, Integer> fruitBalanceMap = Storage.fruitTransactions.stream()
                .collect(Collectors.groupingBy(
                        fruitTransaction -> fruitTransaction.getFruit().getName(),
                        Collectors.mapping(this::calculateQuantityByStrategy,
                                Collectors.summingInt(quantity -> quantity))));

        return fruitBalanceMap.entrySet().stream()
                .map(entry -> new Fruit(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparing(Fruit::getName))
                .collect(Collectors.toList());
    }

    private Integer calculateQuantityByStrategy(FruitTransaction fruitTransaction) {
        return quantityStrategy
                .getQuantityHandler(fruitTransaction.getOperation())
                .getQuantity(fruitTransaction);
    }
}
