package strategy;

import java.util.List;
import model.FruitTransaction;

public interface StrategyImplementation {
    void strategy(List<FruitTransaction> fruitTransactions);
}
