package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FruitService {
    private static final Logger logger = LoggerFactory.getLogger(FruitService.class);

    public Map<String, Integer> getStockBalance(List<Transaction> transactions) {
        Map<String, Integer> stockBalance = new HashMap<>();
        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            String fruit = transaction.getFruit();
            stockBalance.merge(fruit, transaction.getQuantity(),
                    (stockQuantity, transactionQuantity)
                            -> transaction.getOperation() == Operation.BUY
                            ? stockQuantity - transactionQuantity
                            : stockQuantity + transactionQuantity);
            if (stockBalance.get(fruit) < 0) {
                logger.warn("Stock for [" + fruit
                            + "] has negative balance after transaction at line " + i);
            }
        }
        stockBalance.entrySet().removeIf(entry -> entry.getValue() <= 0);
        return stockBalance;
    }
}
