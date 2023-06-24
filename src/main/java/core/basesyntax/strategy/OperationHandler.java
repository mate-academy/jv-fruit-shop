package core.basesyntax.strategy;

import java.util.function.IntUnaryOperator;

public interface OperationHandler {
    IntUnaryOperator changeSaldo(int saldo);
}
