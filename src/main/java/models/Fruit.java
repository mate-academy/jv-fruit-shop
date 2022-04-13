package models;

public final class Fruit {
    private String name;

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object fruit) {
        if (fruit == this) {
            return true;
        }

        if (fruit == null || !(fruit.getClass().equals(Fruit.class))) {
            return false;
        }
        return name.equals(((Fruit)fruit).getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
