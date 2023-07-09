package strategy;

import model.FruitTransaction;
import java.util.List;

public interface FruitShopStrategy {
    void processTransactions(List<FruitTransaction> transactions);
}
