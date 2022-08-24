package core.basesyntax.hadler.impl;

import static core.basesyntax.enums.Operation.BALANCE;
import static core.basesyntax.enums.Operation.RETURN;
import static core.basesyntax.enums.Operation.SUPPLY;

import core.basesyntax.hadler.OperationHandler;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class AddOperationHandler implements OperationHandler {
    @Override
    public int getAmount(String fruit, List<FruitTransaction> transactions) {
        return transactions.stream()
                .filter(transaction ->
                        transaction.getFruit().equals(fruit)
                                && (transaction.getOperation().equals(SUPPLY)
                                || transaction.getOperation().equals(RETURN)
                                || transaction.getOperation().equals(BALANCE)))
                .map(FruitTransaction::getQuantity)
                .reduce(0, Integer::sum);
    }
}
