package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.AmountOfFruitsFromFile;
import java.util.ArrayList;
import java.util.List;

public class AmountOfFruitsFromFileImpl implements AmountOfFruitsFromFile {
    @Override
    public List<Integer> getAmountOfFruitsFromFile(List<String> fruits,
                                                   List<FruitTransaction> fruitTransactions) {
        List<Integer> amounts = new ArrayList<>();

        for (int i = 0; i < fruits.size(); i++) {
            String fruit = fruits.get(i);
            int sum = fruitTransactions.stream()
                    .filter(ft -> ft.getFruit().equals(fruit))
                    .mapToInt(n -> calculateQantityFromOperation(n))
                    .sum();
            amounts.add(sum);
        }
        return amounts;
    }

    private static int calculateQantityFromOperation(FruitTransaction transaction) {
        return transaction.getOperation() == Operation.BALANCE
                ? transaction.getQuantity()
                : transaction.getOperation() == Operation.SUPPLY
                ? transaction.getQuantity()
                : transaction.getOperation() == Operation.RETURN
                ? transaction.getQuantity() : transaction.getQuantity() * -1;//purchase
    }
}
