package strategy;

import java.util.List;
import model.FruitTransaction;

public interface FruitShopStrategy {
    void processTransactions(List<FruitTransaction> transactions);
}
