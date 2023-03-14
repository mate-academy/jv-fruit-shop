package core.basesyntax.strategy;

import java.util.function.IntUnaryOperator;

public class OperationHandlersSupply implements OperationHandler {
    @Override
    public IntUnaryOperator changeSaldo(int saldo) {
        return IntUnaryOperator.identity().andThen(quantity -> saldo + quantity);
    }
}
