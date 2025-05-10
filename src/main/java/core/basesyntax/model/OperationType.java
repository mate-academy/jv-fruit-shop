package core.basesyntax.model;

import core.basesyntax.strategy.BalanceStrategy;
import core.basesyntax.strategy.PurchaseStrategy;
import core.basesyntax.strategy.ReturnStrategy;
import core.basesyntax.strategy.SupplyStrategy;
import java.util.function.IntBinaryOperator;

public enum OperationType {
    BALANCE("b", new BalanceStrategy()),
    SUPPLY("s", new SupplyStrategy()),
    PURCHASE("p", new PurchaseStrategy()),
    RETURN("r", new ReturnStrategy());

    private final String code;
    private final IntBinaryOperator function;

    OperationType(String code, IntBinaryOperator function) {
        this.code = code;
        this.function = function;
    }

    public String getCode() {
        return code;
    }

    public IntBinaryOperator getFunction() {
        return function;
    }
}
