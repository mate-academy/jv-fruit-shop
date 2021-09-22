package core.basesyntax.model;

import core.basesyntax.services.OperationType;
import java.util.Objects;

public class FruitRecordDto {
    private OperationType type;
    private String fruitName;
    private int amount;

    public FruitRecordDto(OperationType type, String fruitName, int amount) {
        this.type = type;
        this.fruitName = fruitName;
        this.amount = amount;
    }

    public OperationType getType() {
        return type;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FruitRecordDto)) {
            return false;
        }
        FruitRecordDto that = (FruitRecordDto) o;
        return getAmount() == that.getAmount()
                    && getType() == that.getType()
                    && Objects.equals(getFruitName(), that.getFruitName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getFruitName(), getAmount());
    }
}
