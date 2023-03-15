package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;
import java.util.function.IntUnaryOperator;

public class OperarionHandlerPurchase implements OperationHandler {
    @Override
    public IntUnaryOperator changeSaldo(int saldo) {
        return IntUnaryOperator.identity().andThen(quantity -> saldo - quantity);
    }
}
