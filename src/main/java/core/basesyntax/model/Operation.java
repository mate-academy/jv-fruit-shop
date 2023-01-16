package core.basesyntax.model;

public class Operation {
    private String name;
    private String shortName;
    private ArithmeticOperation arithmeticOperation;

    public Operation(String name, String shortName, ArithmeticOperation arithmeticOperation) {
        this.name = name;
        this.shortName = shortName;
        this.arithmeticOperation = arithmeticOperation;
    }

    public String getShortName() {
        return shortName;
    }

    public ArithmeticOperation getArithmeticOperation() {
        return arithmeticOperation;
    }

    public enum ArithmeticOperation {
        ADD, SUBTRACT
    }
}
