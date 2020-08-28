package core.basesyntax;

import java.time.LocalDate;

public class ProductsDto {
    private String operation;
    private String name;
    private Integer quantity;
    private LocalDate expirationDate;

    public ProductsDto(String operation, String name, Integer quantity, LocalDate expirationDate) {
        this.operation = operation;
        this.name = name;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
