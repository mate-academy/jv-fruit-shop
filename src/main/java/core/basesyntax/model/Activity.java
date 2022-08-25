package core.basesyntax.model;

import java.util.Objects;

public class Activity {
    private TypeActivity type;
    private String fruit;
    private int count;

    public Activity(TypeActivity type, String fruit, int count) {
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
        Activity activity = (Activity) o;
        return count == activity.count
                && type == activity.type
                && Objects.equals(fruit, activity.fruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, fruit, count);
    }

    @Override
    public String toString() {
        return "Activity{"
                + "type=" + type
                + ", fruit='" + fruit + '\''
                + ", count=" + count
                + '}';
    }
}
