package core.basesyntax;

import java.time.LocalDate;

public class DateAndQuantity {

    private LocalDate date;
    private int quantity;

    public DateAndQuantity(LocalDate date, int quantity) {
        this.date = date;
        this.quantity = quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
