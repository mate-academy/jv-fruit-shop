package core.basesyntax.model.dto;

import core.basesyntax.model.Fruit;
import java.util.Objects;

public class FruitRecordDto {
    private final String operationType;
    private final Fruit fruit;
    private final int amount;

    public FruitRecordDto(String operationType, Fruit fruit, int amount) {
        this.operationType = operationType;
        this.fruit = fruit;
        this.amount = amount;
    }

    public String getOperationType() {
        return operationType;
    }

    public Fruit getFruit() {

        return fruit;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationType, fruit, amount);
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
                && Objects.equals(fruit, fruitDto.fruit)
                && amount == fruitDto.amount;
    }
}
