package core.basesyntax.model;

import java.util.Objects;

public class FruitRecordDto {
    private final String operation;
    private final String nameFruits;
    private final int amount;

    public FruitRecordDto(String operation, String nameFruits, int amount) {
        this.operation = operation;
        this.nameFruits = nameFruits;
        this.amount = amount;
    }

    public String getOperation() {
        return operation;
    }

    public String getNameFruits() {
        return nameFruits;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        FruitRecordDto that = (FruitRecordDto) object;
        return amount == that.amount && Objects.equals(operation, that.operation)
                && Objects.equals(nameFruits, that.nameFruits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, nameFruits, amount);
    }
}
