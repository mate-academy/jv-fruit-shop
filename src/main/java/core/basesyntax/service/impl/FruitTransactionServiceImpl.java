package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    @Override
    public void execute(List<FruitTransaction> transactions, 
            Map<Operation, OperationHandler> strategyMap) {
        OperationStrategy operationStrategy = new OperationStrategyImpl(strategyMap);
        FruitDao fruitDao = new FruitDaoImpl();
        
        for (FruitTransaction transaction : transactions) {
            Integer newQuantity = operationStrategy.get(transaction.getOperation())
                    .getNewQuantityForFruit(transaction);
            fruitDao.replaceValue(transaction.getName(), newQuantity);
        }
    }
}
