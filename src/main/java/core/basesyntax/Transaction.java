package core.basesyntax;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.opencsv.bean.CsvDate;
import java.time.LocalDate;
import java.util.Objects;

public class Transaction {
    @CsvCustomBindByName(column = "type", converter = ConvertOperation.class)
    private Operation operation;
    @CsvBindByName
    private String fruit;
    @CsvBindByName
    private int quantity;
    @CsvBindByName
    @CsvDate("yyyy-MM-dd")
    private LocalDate date;

    public Transaction() {
    }

    public Transaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Transaction(Operation operation, String fruit, int quantity, LocalDate date) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
        this.date = date;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
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
        return quantity == that.quantity
               && operation == that.operation
               && Objects.equals(fruit, that.fruit)
               && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruit, quantity, date);
    }
}
