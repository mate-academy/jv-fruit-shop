package core.basesyntax;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import java.time.LocalDate;
import java.util.Objects;

public class FruitTransaction {
    @CsvBindByName (column = "type")
    private String type;
    @CsvBindByName (column = "fruit")
    private String fruit;
    @CsvBindByName (column = "quantity")
    private int quantity;
    @CsvBindByName (column = "date")
    @CsvDate ("yyyy-MM-dd")
    private LocalDate date;

    public FruitTransaction(String type, String fruit, int quantity, LocalDate date) {
        this.type = type;
        this.fruit = fruit;
        this.quantity = quantity;
        this.date = date;
    }

    public FruitTransaction() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitTransaction that = (FruitTransaction) o;
        return quantity == that.quantity
                && Objects.equals(type, that.type)
                && Objects.equals(fruit, that.fruit)
                && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, fruit, quantity, date);
    }
}
