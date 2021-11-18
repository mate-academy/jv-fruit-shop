package core.basesyntax.service.activity;

public enum TypeActivity {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String name;

    TypeActivity(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
