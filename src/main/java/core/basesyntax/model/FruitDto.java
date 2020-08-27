package core.basesyntax.model;

import java.time.LocalDate;
import java.util.Objects;

public class FruitDto {
    private String typeOperation;
    private String name;
    private LocalDate date;
    private Integer quantity;

    private FruitDto(FruitDtoBuilder builder) {
        this.name = builder.name;
        this.date = builder.date;
        this.quantity = builder.quantity;
        this.typeOperation = builder.typeOperation;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FruitDto)) {
            return false;
        }
        FruitDto fruitDto = (FruitDto) o;
        return (typeOperation == fruitDto.typeOperation
                || typeOperation != null && typeOperation.equals(fruitDto.typeOperation))
                && (name == fruitDto.name || name != null && name.equals(fruitDto.name))
                && (date == fruitDto.date || date != null && date.equals(fruitDto.date))
                && (quantity == fruitDto.quantity
                || quantity != null && quantity.equals(fruitDto.quantity));
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOperation, name, date, quantity);
    }

    public static class FruitDtoBuilder {
        private String typeOperation;
        private String name;
        private LocalDate date;
        private Integer quantity;

        public FruitDtoBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public FruitDtoBuilder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public FruitDtoBuilder setQuantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public FruitDtoBuilder setTypeOperation(String typeOperation) {
            this.typeOperation = typeOperation;
            return this;
        }

        public FruitDto build() {
            return new FruitDto(this);
        }
    }
}
