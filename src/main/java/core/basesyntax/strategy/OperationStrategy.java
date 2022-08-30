package core.basesyntax.strategy;

import core.basesyntax.strategy.impl.BalanceCounterImpl;
import core.basesyntax.strategy.impl.PurchaseCounterImpl;
import core.basesyntax.strategy.impl.ReturnCounterImpl;
import core.basesyntax.strategy.impl.SupplyCounterImpl;

import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {
    public Map<String, Counter> operation = new HashMap<>();

   {
        operation.put("b", new BalanceCounterImpl());
        operation.put("p", new PurchaseCounterImpl());
        operation.put("s", new SupplyCounterImpl());
        operation.put("r", new ReturnCounterImpl());
   }



}
