package core.basesyntax.model;

public class Fruit {
    private String name;
    private int number;

    public Fruit(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Fruit{" + "name='" + name + '\''
                + ", number=" + number + '}';
    }
}
