package core.basesyntax;

import java.time.LocalDate;

public class Transaction {
    private String name;
    private String operationType;
    private int quantity;
    private LocalDate date;

    public Transaction(String name, String operationType, int quantity, LocalDate date) {
        this.name = name;
        this.operationType = operationType;
        this.quantity = quantity;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getOperationType() {
        return operationType;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Transaction that = (Transaction) o;
        if (quantity != that.quantity) {
            return false;
        }
        if (name != null ? !name.equals(that.name) : that.name != null) {
            return false;
        }
        if (operationType != null ? !operationType.equals(that.operationType)
                                    : that.operationType != null) {
            return false;
        }
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (operationType != null ? operationType.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
