package model;

public class ProductAccount {
    private String name;
    private Double amount = 0.00;

    public ProductAccount(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {

        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
