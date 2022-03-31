package strategy;

import java.util.List;
import model.FruitTransaction;

public class StrategyImplementationImpl implements StrategyImplementation {
    private HandlersStore serviceHandler;

    public StrategyImplementationImpl(HandlersStore handlersStore) {
        this.serviceHandler = handlersStore;
    }

    @Override
    public void strategy(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            serviceHandler.getStrategy().get(fruitTransaction.getOperation())
                    .handler(fruitTransaction);
        }
    }
}
