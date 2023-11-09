package core.basesyntax.strategy;

import core.basesyntax.FruitTransaction;
import core.basesyntax.strategy.impl.BalanceTransactionStrategy;
import core.basesyntax.strategy.impl.PurchaseTransactionStrategy;
import core.basesyntax.strategy.impl.ReturnTransactionStrategy;
import core.basesyntax.strategy.impl.SupplyTransactionStrategy;
import java.util.List;
import java.util.Map;

public class FruitTransactionStrategy {

    public Map<String, Integer> operationFromFruit(Map<String, Integer> dataBase,
                                                   List<FruitTransaction> fruitTransactions) {

        BalanceTransactionStrategy balanceTransactionStrategy
                = new BalanceTransactionStrategy();
        PurchaseTransactionStrategy purchaseTransactionStrategy
                = new PurchaseTransactionStrategy();
        SupplyTransactionStrategy supplyTransactionStrategy
                = new SupplyTransactionStrategy();
        ReturnTransactionStrategy returnTransactionStrategy
                = new ReturnTransactionStrategy();

        for (FruitTransaction transaction : fruitTransactions) {
            String fruit = transaction.getFruit();
            int quantity = transaction.getQuantity();
            switch (transaction.getOperation().getCode()) {
                case "b" -> {
                    balanceTransactionStrategy.process(dataBase, fruit, quantity);
                }
                case "p" -> {
                    purchaseTransactionStrategy.process(dataBase, fruit, quantity);
                }
                case "s" -> {
                    supplyTransactionStrategy.process(dataBase, fruit, quantity);
                }
                case "r" -> {
                    returnTransactionStrategy.process(dataBase, fruit, quantity);
                }
                default -> throw new RuntimeException("Unknown operation type");
            }
        }
        return dataBase;
    }
}
