package core.basesyntax.model;

public class Fruit {
    private Integer value;
    private ACTIVITY activity;
    private TYPE type;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public ACTIVITY getActivity() {
        return activity;
    }

    public void setActivity(ACTIVITY activity) {
        this.activity = activity;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public enum ACTIVITY {
        BALANCE, EXPIRED, PURCHASE, RETURN, SUPPLY;
    }

    public enum TYPE {
        APPLE, BANANA, ORANGE, MANGO;
    }
}
