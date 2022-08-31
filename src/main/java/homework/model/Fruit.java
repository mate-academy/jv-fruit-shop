package homework.model;

import java.util.Objects;

public final class Fruit {
    private final String title;

    public Fruit(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fruit fruit1 = (Fruit) o;
        return Objects.equals(title, fruit1.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't clone fruit: " + title, e);
        }
    }
}
