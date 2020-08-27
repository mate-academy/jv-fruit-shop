package core.basesyntax.products;

import java.time.LocalDate;
import java.util.Objects;

public class FruitDto {
    private String operation;
    private String name;
    private int amount;
    private LocalDate expiredDate;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FruitDto fruitDto = (FruitDto) obj;
        return amount == fruitDto.amount
                && Objects.equals(operation, fruitDto.operation)
                && Objects.equals(name, fruitDto.name)
                && Objects.equals(expiredDate, fruitDto.expiredDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, name, amount, expiredDate);
    }
}
