package core.basesyntax.model;

import java.math.BigDecimal;
import java.util.Objects;

public class FruitTransaction {
    private final String fruitName;
    private final BigDecimal fruitPrice;
    private final Operation operationType;

    public FruitTransaction(FruitBuilder fruitBuilder) {
        this.fruitName = fruitBuilder.fruitName;
        this.fruitPrice = fruitBuilder.fruitPrice;
        this.operationType = fruitBuilder.operationType;
    }

    public String getFruitName() {
        return fruitName;
    }

    public BigDecimal getFruitPrice() {
        return fruitPrice;
    }

    public Operation getOperationType() {
        return operationType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitTransaction that = (FruitTransaction) o;
        return Objects.equals(fruitName, that.fruitName)
                && Objects.equals(fruitPrice, that.fruitPrice)
                && operationType == that.operationType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitName, fruitPrice, operationType);
    }

    public static class FruitBuilder {
        private String fruitName;
        private BigDecimal fruitPrice;
        private Operation operationType;

        public FruitBuilder setFruitName(String fruitName) {
            this.fruitName = fruitName;
            return this;
        }

        public FruitBuilder setFruitPrice(BigDecimal fruitPrice) {
            this.fruitPrice = fruitPrice;
            return this;
        }

        public FruitBuilder setOperationType(Operation operationType) {
            this.operationType = operationType;
            return this;
        }

        public FruitTransaction build() {
            return new FruitTransaction(this);
        }
    }
}
