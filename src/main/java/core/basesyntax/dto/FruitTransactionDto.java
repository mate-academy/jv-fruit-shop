package core.basesyntax.dto;

import java.util.Objects;

public class FruitTransactionDto {
    private String operationType;
    private String nameFruit;
    private int quantity;

    public FruitTransactionDto(String operationType, String nameFruit, int quantity) {
        this.operationType = operationType;
        this.nameFruit = nameFruit;
        this.quantity = quantity;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public void setNameFruit(String nameFruit) {
        this.nameFruit = nameFruit;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNameFruit() {
        return nameFruit;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (operationType == null ? 0 : operationType.hashCode());
        result = 31 * result + (nameFruit == null ? 0 : nameFruit.hashCode());
        result = 31 * result + quantity;
        return result;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != FruitTransactionDto.class) {
            return false;
        }
        FruitTransactionDto dto = (FruitTransactionDto)object;
        return Objects.equals(this.operationType,dto.operationType)
                && Objects.equals(this.nameFruit,dto.nameFruit)
                && this.quantity == dto.quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
