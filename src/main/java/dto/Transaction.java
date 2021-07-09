package dto;

public class Transaction {
    private String operation;
    private String name;
    private int quantitiy;

    public Transaction(String operation, String name, int quantitiy) {
        this.operation = operation;
        this.name = name;
        this.quantitiy = quantitiy;
    }

    public String getOperation() {
        return operation;
    }

    public String getName() {
        return name;
    }

    public int getQuantitiy() {
        return quantitiy;
    }
}
