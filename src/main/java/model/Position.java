package model;

import java.time.LocalDate;

public class Position {
    private String name;
    private int quantity;
    private LocalDate date;

    public Position(String name, int quantity, LocalDate date) {
        this.name = name;
        this.quantity = quantity;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
