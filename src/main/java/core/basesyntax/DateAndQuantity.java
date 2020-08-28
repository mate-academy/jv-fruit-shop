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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        DateAndQuantity dateAndQuantity = (DateAndQuantity) obj;

        return (date == dateAndQuantity.date
                || (date != null && date.isEqual(dateAndQuantity.getDate())));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + quantity;
        return result;
    }
}
