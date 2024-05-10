package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionProcessor;
import core.basesyntax.service.StrategyService;
import core.basesyntax.strategy.StrategyHandler;
import java.util.List;

public class FruitTransactionProcessorImpl implements FruitTransactionProcessor {
    private final FruitDao fruitDao;
    private final StrategyService strategyService;
    private StrategyHandler strategyHandler;

    public FruitTransactionProcessorImpl(FruitDao fruitDao, StrategyService strategyService) {
        this.fruitDao = fruitDao;
        this.strategyService = strategyService;
    }

    @Override
    public void fillStorage(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            if (!fruitDao.getFruitMap().containsKey(fruitTransaction.getFruitName())) {
                fruitDao.getFruitMap()
                        .put(fruitTransaction.getFruitName(), fruitTransaction.getQuantity());
            } else {
                String fruitName = fruitTransaction.getFruitName();
                strategyService.getStrategy(fruitTransaction.getOperation());
                Integer quantity = strategyHandler.handle(fruitTransaction);
                fruitDao.updateQuantity(fruitName, quantity);
            }
        }
    }
}
