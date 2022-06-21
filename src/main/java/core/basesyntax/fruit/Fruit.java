package core.basesyntax.fruit;

import java.util.Objects;

public class Fruit {
    protected String typeAction;
    protected String name;
    protected int amount;

    public Fruit(String typeAction, String name, int amount) {
        this.typeAction = typeAction;
        this.name = name;
        this.amount = amount;
    }

    public String getTypeAction() {
        return typeAction;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fruit model = (Fruit) o;
        return amount == model.amount
                && Objects.equals(typeAction, model.typeAction) && Objects.equals(name, model.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeAction, name, amount);
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "typeAction='" + typeAction + '\''
                + ", name='" + name + '\''
                + ", amount=" + amount
                + '}';
    }
}
