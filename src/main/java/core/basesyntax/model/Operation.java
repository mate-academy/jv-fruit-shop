package core.basesyntax.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import java.time.LocalDate;
import java.util.Objects;

public class Operation {
    @CsvBindByName (column = "type")
    private String type;
    @CsvBindByName (column = "fruit")
    private String fruit;
    @CsvBindByName (column = "quantity")
    private int quantity;
    @CsvBindByName(column = "date")
    @CsvDate("yyyy-MM-dd")
    private LocalDate expDate;

    public Operation(String type, String fruit, int quantity, LocalDate expDate) {
        this.type = type;
        this.fruit = fruit;
        this.quantity = quantity;
        this.expDate = expDate;
    }

    public Operation() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operation operation = (Operation) o;
        return quantity == operation.quantity
                && type.equals(operation.type)
                && fruit.equals(operation.fruit)
                && expDate.equals(operation.expDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, fruit, quantity, expDate);
    }

    public String getType() {
        return type;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

}
