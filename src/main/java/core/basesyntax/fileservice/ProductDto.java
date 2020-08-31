package core.basesyntax.fileservice;

import core.basesyntax.storeservice.Operation;
import java.time.LocalDate;
import java.util.Objects;

public class ProductDto {
    private final Operation operation;
    private final String type;
    private final LocalDate expDate;
    private final Integer quantity;

    public ProductDto(Operation operation, String type, LocalDate expDate, Integer quantity) {
        this.operation = operation;
        this.type = type;
        this.expDate = expDate;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getType() {
        return type;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductDto that = (ProductDto) o;
        return operation.getClass() == that.operation.getClass()
                && Objects.equals(type, that.type)
                && Objects.equals(expDate, that.expDate)
                && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, type, expDate, quantity);
    }
}
