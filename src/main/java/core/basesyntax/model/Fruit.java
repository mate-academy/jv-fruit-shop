package core.basesyntax.model;

import java.time.LocalDate;

public class Fruit {
    private String name;
    private LocalDate expirationDate;

    public Fruit(String name, LocalDate expirationDate) {
        this.name = name;
        this.expirationDate = expirationDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
