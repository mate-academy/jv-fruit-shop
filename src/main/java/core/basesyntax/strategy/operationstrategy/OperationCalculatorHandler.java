package core.basesyntax.strategy.operationstrategy;

import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.strategy.operationstrategy.impl.BalanceOperationCalculatorImpl;
import core.basesyntax.strategy.operationstrategy.impl.PurchaseOperationCalculatorImpl;
import core.basesyntax.strategy.operationstrategy.impl.ReturnOperationCalculatorImpl;
import core.basesyntax.strategy.operationstrategy.impl.SupplyOperationCalculatorImpl;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OperationCalculatorHandler {
    private static final Map<Operation, OperationCalculator> operationCalculators = new HashMap<>();

    static {
        operationCalculators.put(Operation.BALANCE, new BalanceOperationCalculatorImpl());
        operationCalculators.put(Operation.SUPPLY, new SupplyOperationCalculatorImpl());
        operationCalculators.put(Operation.PURCHASE, new PurchaseOperationCalculatorImpl());
        operationCalculators.put(Operation.RETURN, new ReturnOperationCalculatorImpl());
    }

    public OperationCalculator getOperationCalculator(Operation operation) {
        Optional<OperationCalculator> calculatorOptional = Optional
                .of(operationCalculators.get(operation));
        return calculatorOptional.orElseThrow(
                () -> new RuntimeException("Not supported operation type: " + operation));
    }
}
