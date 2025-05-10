package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.AmountOfFruitsFromFile;
import core.basesyntax.service.OperationStrategy;
import java.util.ArrayList;
import java.util.List;

public class AmountOfFruitsFromFileImpl implements AmountOfFruitsFromFile {
    private final OperationStrategy operationStrategy;

    public AmountOfFruitsFromFileImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public List<Integer> getAmountOfFruitsFromFile(List<String> fruits,
                                                   List<FruitTransaction> fruitTransactions) {
        List<Integer> amounts = new ArrayList<>();

        for (int i = 0; i < fruits.size(); i++) {
            String fruit = fruits.get(i);
            int sum = fruitTransactions.stream()
                    .filter(ft -> ft.getFruit().equals(fruit))
                    .mapToInt(this::calculateQuantityFromOperation)
                    .sum();
            amounts.add(sum);
        }
        return amounts;
    }

    private int calculateQuantityFromOperation(FruitTransaction transaction) {
        return operationStrategy.getHandler(transaction.getOperation()).getOperation(transaction);
    }
}
