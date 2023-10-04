package core.basesyntax.function.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitTransactionAction;
import core.basesyntax.strategy.impl.FruitTransactionActionBalanceImpl;
import core.basesyntax.strategy.impl.FruitTransactionActionPurchaseImpl;
import core.basesyntax.strategy.impl.FruitTransactionActionReturnImpl;
import core.basesyntax.strategy.impl.FruitTransactionActionSupplyImpl;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class TransactionCalculator implements Function<FruitTransaction, Map<String, Integer>> {
    private static final String BALANCE_TRANSACTION = "b";
    private static final String SUPPLY_TRANSACTION = "s";
    private static final String PURCHASE_TRANSACTION = "p";
    private static final String RETURN_TRANSACTION = "r";
    private static final Map<String, FruitTransactionAction> strategy = new HashMap<>();

    private FruitTransactionAction action;

    public TransactionCalculator() {
        strategy.put(BALANCE_TRANSACTION, new FruitTransactionActionBalanceImpl());
        strategy.put(SUPPLY_TRANSACTION, new FruitTransactionActionSupplyImpl());
        strategy.put(PURCHASE_TRANSACTION, new FruitTransactionActionPurchaseImpl());
        strategy.put(RETURN_TRANSACTION, new FruitTransactionActionReturnImpl());
    }

    @Override
    public Map<String, Integer> apply(FruitTransaction fruitTransaction) {
        action = strategy.get(fruitTransaction.getOperation().getCode());
        Map<String, Integer> fruitQuantity = new HashMap<>();
        fruitQuantity.put(fruitTransaction.getFruit(), action.transactionAction(fruitTransaction));
        return fruitQuantity;
    }
}
