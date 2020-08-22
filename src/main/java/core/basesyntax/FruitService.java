package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitService {
    public Map<String, Integer> getStockBalance(List<Transaction> transactions) {
        Map<String, Integer> stockBalance = new HashMap<>();
        transactions.forEach(t -> stockBalance.merge(t.getFruit(), t.getQuantity(),
                (i1, i2) -> t.getOperation() == Operation.BUY ? i1 - i2 : i1 + i2));
        return stockBalance;
    }
}
