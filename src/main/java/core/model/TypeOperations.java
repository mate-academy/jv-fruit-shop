package core.model;

public enum TypeOperations {
    BALANCE("b"), SUPPLY("s"), PURCHASE("p"), RETURN("r");

    private final String typeOperation;

    TypeOperations(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    public String get() {
        return typeOperation;
    }
}
