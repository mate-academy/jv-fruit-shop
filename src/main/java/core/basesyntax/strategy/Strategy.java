package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.utils.CalculateOperation;
import core.basesyntax.utils.impl.BalanceOperation;
import core.basesyntax.utils.impl.PurchaseOperation;
import core.basesyntax.utils.impl.ReturnOperation;
import core.basesyntax.utils.impl.SupplyOperation;
import java.util.Map;

public class Strategy {
    private static final Map<FruitTransaction.Operation, CalculateOperation> operations;

    static {
        operations = Map.of(FruitTransaction.Operation.BALANCE, new BalanceOperation(),
        FruitTransaction.Operation.PURCHASE, new PurchaseOperation(),
        FruitTransaction.Operation.SUPPLY, new SupplyOperation(),
        FruitTransaction.Operation.RETURN, new ReturnOperation());
    }

    public CalculateOperation getCalculateOperation(FruitTransaction transaction) {
        return operations.get(transaction.getOperation());
    }
}
