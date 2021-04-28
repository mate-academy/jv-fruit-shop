package core.basesyntax.dao;

import core.basesyntax.model.Type;
import java.util.Objects;

public class FruitRecordDto {
    private Type type;
    private String fruitName;
    private int quantity;

    public FruitRecordDto(Type type, String fruitName, int quantity) {
        this.type = type;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public Type getType() {
        return type;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FruitRecordDto that = (FruitRecordDto) o;

        if (quantity != that.quantity) {
            return false;
        }
        if (type != that.type) {
            return false;
        }
        return Objects.equals(fruitName, that.fruitName);
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (fruitName != null ? fruitName.hashCode() : 0);
        result = 31 * result + quantity;
        return result;
    }
}
