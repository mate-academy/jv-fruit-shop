package dto;

import java.time.LocalDate;

public class PositionDto {
    private String operation;
    private String fruitName;
    private int quantity;
    private LocalDate date;

    public PositionDto(String operation, String fruitName, int quantity, LocalDate date) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.quantity = quantity;
        this.date = date;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
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
}
