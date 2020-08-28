package core.basesyntax.parsers;

import java.time.LocalDate;

public class Transaction {
    private String operaton;
    private String fruitType;
    private int quantity;
    private LocalDate expirationDate;

    public Transaction() {

    }
    public Transaction(String operaton, String fruitType, int quantity, LocalDate expirationDate) {
        this.operaton = operaton;
        this.fruitType = fruitType;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return   "\n" + operaton + "," +
                 fruitType + "," +
                 quantity + "," +
                 expirationDate;
    }

    public String getOperaton() {
        return operaton;
    }

    public void setOperaton(String operaton) {
        this.operaton = operaton;
    }

    public String getFruitType() {
        return fruitType;
    }

    public void setFruitType(String fruitType) {
        this.fruitType = fruitType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
