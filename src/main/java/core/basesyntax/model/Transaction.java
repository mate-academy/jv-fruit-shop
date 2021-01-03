package core.basesyntax.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.opencsv.bean.CsvDate;
import core.basesyntax.ConvertOperation;
import java.time.LocalDate;
import java.util.Objects;

public class Transaction {
    @CsvCustomBindByName(column = "type", converter = ConvertOperation.class)
    private Operation operation;
    @CsvBindByName(column = "fruit")
    private String fruitName;
    @CsvBindByName
    private int quantity;
    @CsvBindByName
    @CsvDate("yyyy-MM-dd")
    private LocalDate date;

    public Transaction() {
    }

    public Transaction(Operation operation, String fruitName, int quantity, LocalDate date) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.quantity = quantity;
        this.date = date;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
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

    public String getFruitName() {
        return fruitName;
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
               && Objects.equals(fruitName, that.fruitName)
               && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruitName, quantity, date);
    }
}
