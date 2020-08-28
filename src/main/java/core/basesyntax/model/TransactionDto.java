package core.basesyntax.model;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;
import java.time.LocalDate;
import java.util.Objects;

public class TransactionDto {
    @CsvBindByPosition(position = 0)
    private String operation;
    @CsvBindByPosition(position = 1)
    private String fruit;
    @CsvBindByPosition(position = 2)
    private int quantity;
    @CsvBindByPosition(position = 3)
    @CsvDate("yyyy-MM-dd")
    private LocalDate purchaseDate;

    public TransactionDto(String operation, String fruit, int quantity, LocalDate purchaseDate) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
    }

    public String getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TransactionDto operation = (TransactionDto) o;
        return quantity == operation.quantity
                && Objects.equals(this.operation, operation.operation)
                && Objects.equals(fruit, operation.fruit)
                && Objects.equals(purchaseDate, operation.purchaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruit, quantity, purchaseDate);
    }
}
