package core.basesyntax.model;

import java.time.LocalDate;
import java.util.Objects;

public class FruitDto {
    private String operation;
    private String fruit;
    private int quantity;
    private LocalDate expirationDate;

    public FruitDto(String operation, String fruit, int quantity, LocalDate expirationDate) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
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

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitDto operation = (FruitDto) o;
        return quantity == operation.quantity
                && Objects.equals(this.operation, operation.operation)
                && Objects.equals(fruit, operation.fruit)
                && Objects.equals(expirationDate, operation.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruit, quantity, expirationDate);
    }
}
