package core.basesyntax.model;

public class Fruit {
    private String fruitname;

    public Fruit(String fruitname) {
        this.fruitname = fruitname;
    }

    public String getFruitName() {
        return fruitname;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (fruitname == null ? 0 : fruitname.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object newFruit) {
        if (newFruit.getClass().equals(Fruit.class)) {
            Fruit castedFruit = (Fruit) newFruit;
            return ((this.fruitname == null && castedFruit.getFruitName() == null)
                    || (this.fruitname != null
                    && castedFruit.fruitname != null
                    && this.fruitname.equals(castedFruit.getFruitName())));
        }
        return false;
    }
}
