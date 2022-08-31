package core.basesyntax.model;

public class FruitTransaction {
    private TypeActivity type;
    private Fruit fruit;
    private int count;

    public FruitTransaction(TypeActivity type, Fruit fruit, int count) {
        this.type = type;
        this.fruit = fruit;
        this.count = count;
    }

    public TypeActivity getType() {
        return type;
    }

    public void setType(TypeActivity type) {
        this.type = type;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "FruitTransaction{"
                + "type=" + type
                + ", fruit=" + fruit.toString()
                + ", count=" + count
                + '}';
    }
}
