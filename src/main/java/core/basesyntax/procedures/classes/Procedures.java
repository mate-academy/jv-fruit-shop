package core.basesyntax.procedures.classes;

public enum Procedures {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String procedure;

    Procedures(String procedure) {
        this.procedure = procedure;
    }

    public String getProcedure() {
        return procedure;
    }
}
