package core.basesyntax.service.impl;

import core.basesyntax.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.ChooseStrategyHandler;
import core.basesyntax.strategy.impl.ChooseStrategyHandlerImpl;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private ChooseStrategyHandler chooseStrategyHandler;

    public FruitServiceImpl(ChooseStrategyHandlerImpl chooseStrategyHandlerImpl) {
        this.chooseStrategyHandler = chooseStrategyHandlerImpl;
    }

    @Override
    public void chooseStrategy(List<FruitTransaction> transactionList) {
        for (FruitTransaction fruitTransaction : transactionList) {
            chooseStrategyHandler.get(fruitTransaction).operation(fruitTransaction);
        }
    }
}
