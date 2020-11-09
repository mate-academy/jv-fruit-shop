package core.basesyntax.dto;

import java.time.LocalDate;
import java.util.Objects;

public class FruitDto {
    private String operation;
    private String fruitName;
    private int amount;
    private LocalDate fruitDtoDate;

    public FruitDto(String operation, String fruitName, String amount, String fruitDtoDate) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.amount = Integer.parseInt(amount);
        this.fruitDtoDate = LocalDate.parse(fruitDtoDate);
    }

    public FruitDto() {
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = Integer.parseInt(amount);
    }

    public LocalDate getFruitDtoDate() {
        return fruitDtoDate;
    }

    public void setFruitDtoDate(String fruitDtoDate) {
        this.fruitDtoDate = LocalDate.parse(fruitDtoDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitDto item = (FruitDto) o;
        return getAmount() == item.getAmount()
                && Objects.equals(getOperation(), item.getOperation())
                && Objects.equals(getFruitName(), item.getFruitName())
                && Objects.equals(getFruitDtoDate(), item.getFruitDtoDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOperation(), getFruitName(), getAmount(), getFruitDtoDate());
    }
}
