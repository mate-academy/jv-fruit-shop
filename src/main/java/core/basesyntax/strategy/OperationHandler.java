package core.basesyntax.strategy;

public interface OperationHandler {
    String COMMA_SEPARATOR = ",";

    void accept(String data);
}
