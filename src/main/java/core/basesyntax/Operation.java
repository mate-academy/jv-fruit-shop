package core.basesyntax;
/*
Operations enum
*/
public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    Operation(String code) {
        this.code = code;
    }
    private String code;

    public String getCode() {
        return code;
    }

    public static Operation getOperationFromCode(String code) {
        switch (code) {
            case "b":
                return Operation.BALANCE;
            case "s":
                return Operation.SUPPLY;
            case "p":
                return Operation.PURCHASE;
            case "r":
                return Operation.RETURN;
            default:
                return null;
        }
    }
}
