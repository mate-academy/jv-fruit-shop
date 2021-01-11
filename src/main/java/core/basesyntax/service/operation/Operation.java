package core.basesyntax.service.operation;

public class Operation {
    private Type operation;

    public Type getOperation() {
        return operation;
    }

    public boolean checkOperation(Type operation) {
        if (operation.equals(Operation.Type.S)
                || operation.equals(Operation.Type.P)
                || operation.equals(Operation.Type.R)) {
            this.operation = operation;
            return true;
        }
        return false;
    }

    public enum Type {
        B, S, P, R;
    }
}
