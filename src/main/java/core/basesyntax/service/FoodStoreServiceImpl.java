
package core.basesyntax.service;

import static core.basesyntax.db.Storage.reportData;

import core.basesyntax.model.FruitTransactions;
import core.basesyntax.strategy.TypeStrategy;
import core.basesyntax.strategy.TypeStrategyImpl;
import core.basesyntax.strategy.type.BalanceTypeHandler;
import core.basesyntax.strategy.type.PurchaseTypeHandler;
import core.basesyntax.strategy.type.ReturnTypeHandler;
import core.basesyntax.strategy.type.SupplyTypeHandler;
import core.basesyntax.strategy.type.TypeHandlers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodStoreServiceImpl implements FoodStoreService {
    private Map<Character, TypeHandlers> typeHandlersMap = new HashMap<>() {
        {
            put('b', new BalanceTypeHandler());
            put('s', new SupplyTypeHandler());
            put('p', new PurchaseTypeHandler());
            put('r', new ReturnTypeHandler());
        }
    };
    private TypeStrategy typeStrategy = new TypeStrategyImpl(typeHandlersMap);

    @Override
    public void proccessOperaton(List<FruitTransactions> fruitTransactionsList) {
        for (FruitTransactions transactions : fruitTransactionsList) {
            if (!reportData.containsKey(transactions.getName())) {
                reportData.put(transactions.getName(),transactions.getQuantity());
            }
            checkValidType(transactions);
            int newValue = typeStrategy.get(transactions.getType())
                    .operation(reportData.get(transactions.getName()),transactions.getQuantity());
            checkNegativeBalance(newValue);
            reportData.put(transactions.getName(), newValue);
        }
    }

    private void checkValidType(FruitTransactions transactions) {
        if (typeStrategy.get(transactions.getType()) == null) {
            throw new RuntimeException("Type: '" + transactions.getType() + "' not valid!");
        }
    }

    private void checkNegativeBalance(int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Balance less then 0! Current balance: "
                    + quantity);
        }
    }
}

