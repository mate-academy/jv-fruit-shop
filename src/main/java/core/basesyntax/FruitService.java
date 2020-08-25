package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitService {
    public Map<String, Integer> getStockBalance(List<Transaction> transactions) {
        Map<String, Integer> stockBalance = new HashMap<>();
        transactions.forEach(t -> stockBalance.merge(t.getFruit(), t.getQuantity(),
                (stockQuantity, transactionQuantity)
                        -> t.getOperation() == Operation.BUY
                        ? stockQuantity - transactionQuantity
                        : stockQuantity + transactionQuantity));
        stockBalance.entrySet().removeIf(entry -> entry.getValue() <= 0);
        return stockBalance;
    }
}
