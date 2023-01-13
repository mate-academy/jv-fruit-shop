package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.utils.CalculateOperation;
import core.basesyntax.utils.impl.BalanceOperation;
import core.basesyntax.utils.impl.PurchaseOperation;
import core.basesyntax.utils.impl.ReturnOperation;
import core.basesyntax.utils.impl.SupplyOperation;
import java.util.HashMap;
import java.util.Map;

public class Strategy {

    private static final Map<FruitTransaction.Operation, CalculateOperation> operations =
            new HashMap<>();

    static {
        operations.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operations.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operations.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        operations.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
    }

    public CalculateOperation getCalculateOperation(FruitTransaction transaction) {
        return operations.get(transaction.getOperation());
    }
}
