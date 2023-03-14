package core.basesyntax.model;

public class Fruit {
    private Integer value;

    public Fruit(Integer value) {
        this.value = value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
