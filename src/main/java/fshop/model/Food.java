package fshop.model;

import java.util.Objects;

public class Food {
    private String name;
    private Integer number;

    public Food(String name, Integer number) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(number);
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setName(String name) {
        Objects.requireNonNull(name);
        this.name = name;
    }

    public void setNumber(Integer number) {
        Objects.requireNonNull(number);
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return Objects.equals(name, food.name)
                && Objects.equals(number, food.number);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + (name != null ? name.hashCode() : 0);
        result = result * 31 + (number != null ? number.hashCode() : 0);
        return result;
    }
}
