package core.basesyntax.model;

import java.time.LocalDate;

public class Fruit implements Comparable<Fruit> {
    private String type;
    private int stockBalance;
    private LocalDate date;

    public Fruit(String type, int stockBalance, LocalDate date) {
        setType(type);
        setDate(date);
        this.stockBalance = stockBalance;
    }

    public String getType() {
        return type;
    }

    public int getStock_balance() {
        return stockBalance;
    }

    public LocalDate getDate() {
        return date;
    }

    private void setType(String type) {
        type = type
                .trim()
                .toLowerCase();
        this.type = type;
    }

    public void setStock_balance(int stockBalance) {
        this.stockBalance = stockBalance;
    }

    private void setDate(LocalDate date) {
        this.date = date;
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
        if (type != null ? !type.equals(fruit.type) : fruit.type != null) {
            return false;
        }
        return date != null ? date.equals(fruit.date) : fruit.date == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "type='" + type + '\''
                + ", stock_balance=" + stockBalance
                + ", date=" + date + '}';
    }

    @Override
    public int compareTo(Fruit o) {
        if (date.isEqual(o.getDate())) {
            return 0;
        }
        return date.isBefore(o.getDate()) ? -1 : 1;
    }
}
