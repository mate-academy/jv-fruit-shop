package core.basesyntax.model;

public enum TypeActivity {
    BALANCE("b"), SUPPLY("s"), PURCHASE("p"), RETURN("r");

    private String label;

    TypeActivity(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
