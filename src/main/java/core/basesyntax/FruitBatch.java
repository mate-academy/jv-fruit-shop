package core.basesyntax;

import java.time.LocalDate;
import java.util.Objects;

public final class FruitBatch {
    private final String fruitType;
    private final LocalDate expiryDate;

    public FruitBatch(String fruitType, LocalDate expiryDate) {
        this.fruitType = fruitType;
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getFruitType() {
        return fruitType;
    }

    @Override
    protected FruitBatch clone() {
        return new FruitBatch(fruitType, expiryDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitBatch fruitBatch = (FruitBatch) o;
        return Objects.equals(fruitType, fruitBatch.fruitType)
                && Objects.equals(expiryDate, fruitBatch.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitType, expiryDate);
    }

    @Override
    public String toString() {
        return "FruitBatch{"
                + "fruitType='"
                + fruitType + '\''
                + ", expiryDate=" + expiryDate
                + '}';
    }
}
