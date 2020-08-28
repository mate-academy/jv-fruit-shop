package core.basesyntax;

import java.util.Objects;

public class Transaction {
    private String typeOfOperation;
    private String typeOfFruit;
    private int amount;
    private String expirationDate;

    public Transaction(String typeOfOperation, String typeOfFruit,
                       int amount, String expirationDate) {
        this.typeOfOperation = typeOfOperation;
        this.typeOfFruit = typeOfFruit;
        this.amount = amount;
        this.expirationDate = expirationDate;
    }

    public String getTypeOfOperation() {
        return typeOfOperation;
    }

    public void setTypeOfOperation(String typeOfOperation) {
        this.typeOfOperation = typeOfOperation;
    }

    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    public void setTypeOfFruit(String typeOfFruit) {
        this.typeOfFruit = typeOfFruit;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transaction that = (Transaction) o;
        return amount == that.amount
                && Objects.equals(typeOfOperation, that.typeOfOperation)
                && Objects.equals(typeOfFruit, that.typeOfFruit)
                && Objects.equals(expirationDate, that.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfOperation, typeOfFruit, amount, expirationDate);
    }

    @Override
    public String toString() {
        return "Transaction{"
                + "typeOfOperation='" + typeOfOperation + '\''
                + ", typeOfFruit='" + typeOfFruit + '\''
                + ", amount=" + amount
                + ", expirationDate='" + expirationDate + '\''
                + '}';
    }
}
