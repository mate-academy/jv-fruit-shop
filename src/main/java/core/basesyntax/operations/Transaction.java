package core.basesyntax.operations;

import java.time.LocalDate;
import java.util.Objects;

public class Transaction {
    private String typeOfOperation;
    private String typeOfFruit;
    private int amount;
    private LocalDate expirationDate;

    public Transaction(String typeOfOperation, String typeOfFruit,
                       int amount, LocalDate expirationDate) {
        this.typeOfOperation = typeOfOperation;
        this.typeOfFruit = typeOfFruit;
        this.amount = amount;
        this.expirationDate = expirationDate;
    }

    public String getTypeOfOperation() {
        return typeOfOperation;
    }

    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    public int getAmount() {
        return amount;
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
