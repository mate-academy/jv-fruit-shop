package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CalculatorService;
import core.basesyntax.strategy.ChooseStrategyHandler;
import core.basesyntax.strategy.impl.ChooseStrategyHandlerImpl;
import java.util.List;

public class CalculatorServiceImpl implements CalculatorService {
    private ChooseStrategyHandler chooseStrategyHandler;

    public CalculatorServiceImpl(ChooseStrategyHandlerImpl chooseStrategyHandlerImpl) {
        this.chooseStrategyHandler = chooseStrategyHandlerImpl;
    }

    @Override
    public void calculate(List<FruitTransaction> transactionList) {
        for (FruitTransaction fruitTransaction : transactionList) {
            chooseStrategyHandler.getHandler(fruitTransaction).operation(fruitTransaction);
        }
    }
}
