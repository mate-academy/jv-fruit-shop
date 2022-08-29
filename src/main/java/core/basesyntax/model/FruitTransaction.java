package core.basesyntax.model;

import java.util.Objects;

public class FruitTransaction {
    private TypeActivity type;
    private String fruit;
    private int count;

    public FruitTransaction(TypeActivity type, String fruit, int count) {
        this.type = type;
        this.fruit = fruit;
        this.count = count;
    }

    public TypeActivity getType() {
        return type;
    }

    public String getFruit() {
        return fruit;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitTransaction fruitTransaction = (FruitTransaction) o;
        return count == fruitTransaction.count
                && type == fruitTransaction.type
                && Objects.equals(fruit, fruitTransaction.fruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, fruit, count);
    }

    @Override
    public String toString() {
        return "FruitTransaction{"
                + "type=" + type
                + ", fruit='" + fruit + '\''
                + ", count=" + count
                + '}';
    }
}
