package core.basesyntax;

import java.time.LocalDate;
import java.util.Objects;

public class ProductsDto {
    private String operation;
    private String name;
    private int quantity;
    private LocalDate date;

    public ProductsDto(String operation, String name, int quantity, LocalDate expirationDate) {
        this.operation = operation;
        this.name = name;
        this.quantity = quantity;
        this.date = expirationDate;
    }

    public String getOperation() {
        return operation;
    }

    public String getName() {
        return name;
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
        ProductsDto that = (ProductsDto) o;
        return quantity == that.quantity
                && Objects.equals(operation, that.operation)
                && Objects.equals(name, that.name)
                && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, name, quantity, date);
    }
}
