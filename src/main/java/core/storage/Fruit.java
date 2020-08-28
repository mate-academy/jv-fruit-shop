package core.storage;

import java.time.LocalDate;


public class Fruit {
    private String type;
    private LocalDate expireDate;

    public Fruit(String type, LocalDate expireDate) {
        this.type = type;
        this.expireDate = expireDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
