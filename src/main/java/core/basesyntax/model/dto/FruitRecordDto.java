package core.basesyntax.model.dto;

import core.basesyntax.service.impl.OperationType;
import java.util.Objects;

public class FruitRecordDto {
    private final OperationType operationType;
    private final String name;
    private final int amount;

    public FruitRecordDto(OperationType operationType, String fruit, int amount) {
        this.operationType = operationType;
        this.name = fruit;
        this.amount = amount;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationType, name, amount);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        FruitRecordDto fruitDto = (FruitRecordDto) obj;
        return Objects.equals(operationType, fruitDto.operationType)
                && Objects.equals(name, fruitDto.name)
                && amount == fruitDto.amount;
    }
}
