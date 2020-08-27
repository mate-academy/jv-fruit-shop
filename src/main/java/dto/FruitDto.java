package dto;

public class FruitDto {
    private String operation;
    private String fruitName;
    private int quantity;
    private String date;

    public FruitDto(String operation, String fruitName, int quantity, String date) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
