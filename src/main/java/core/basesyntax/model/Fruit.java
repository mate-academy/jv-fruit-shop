package core.basesyntax.model;

public class Fruit {
    private String fruitType;
    private int amount;

    public String getFruitType() {
        return fruitType;
    }

    public void setFruitType(String fruitType) {
        this.fruitType = fruitType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        int result = 17;
        if (this != null) {
            result += 31 * (fruitType == null ? 0 : fruitType.hashCode());
            result += 31 * amount;
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() == obj.getClass()) {
            Fruit currentFruit = (Fruit) obj;
            return (currentFruit.fruitType == this.fruitType
                    || (currentFruit.fruitType != null
                    && currentFruit.fruitType.equals(this.fruitType)))
                    && this.amount == currentFruit.amount;
        }
        return false;
    }
}
