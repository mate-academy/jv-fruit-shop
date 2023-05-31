package core.basesyntax.strategy.handler;

public interface OperationHandler {

    Integer operate(Integer transactionValue, Integer oldValue);
}
