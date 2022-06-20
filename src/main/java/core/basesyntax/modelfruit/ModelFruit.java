package core.basesyntax.modelfruit;

import java.util.Objects;

public class ModelFruit {
    protected String typeAction;
    protected String name;
    protected int amount;

    public ModelFruit(String typeAction, String name, int amount) {
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
        ModelFruit model = (ModelFruit) o;
        return amount == model.amount
                && Objects.equals(typeAction, model.typeAction) && Objects.equals(name, model.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeAction, name, amount);
    }

    @Override
    public String toString() {
        return "ModelFruit{"
                + "typeAction='" + typeAction + '\''
                + ", name='" + name + '\''
                + ", amount=" + amount
                + '}';
    }
}
