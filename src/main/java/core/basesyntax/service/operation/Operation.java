package core.basesyntax.service.operation;

public class Operation {
    private Type operation;

    public Type getOperation() {
        return operation;
    }

    public void setOperation(Type operation) {
        this.operation = operation;
    }

    public enum Type {
        S, P, R;
    }
}
