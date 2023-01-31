package core.basesyntax.model;

import java.time.LocalDate;
import java.util.Objects;

public class Fruit implements Comparable<Fruit> {
    private final String type;
    private int stockBalance;
    private final LocalDate date;

    public Fruit(String type, int stockBalance, LocalDate date) {
        this.type = type.trim();
        this.date = date;
        this.stockBalance = stockBalance;
    }

    public String getType() {
        return type;
    }

    public int getStockBalance() {
        return stockBalance;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setStock_balance(int stockBalance) {
        this.stockBalance = stockBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fruit fruit = (Fruit) o;
        if (!Objects.equals(type, fruit.type)) {
            return false;
        }
        return Objects.equals(date, fruit.date);
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Fruit o) {
        if (date.isEqual(o.getDate())) {
            return 0;
        }
        return date.isBefore(o.getDate()) ? -1 : 1;
    }
}
