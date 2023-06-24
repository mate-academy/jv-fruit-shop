package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.UpdateDataStorageService;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.utils.CalculateOperation;
import java.util.List;

public class UpdateDataStorageServiceImpl implements UpdateDataStorageService {
    private static Strategy strategy = new Strategy();

    @Override
    public void updateData(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            CalculateOperation calc = strategy.getCalculateOperation(fruitTransaction);
            calc.count(fruitTransaction);
        }
    }
}
