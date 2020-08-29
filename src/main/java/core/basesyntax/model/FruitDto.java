package core.basesyntax.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import java.time.LocalDate;
import java.util.Objects;

public class FruitDto {
    @CsvBindByName (column = "type")
    private String type;
    @CsvBindByName (column = "fruit")
    private String fruit;
    @CsvBindByName (column = "quantity")
    private int quantity;
    @CsvBindByName(column = "date")
    @CsvDate("yyyy-MM-dd")
    private LocalDate expDate;

    public FruitDto(String type, String fruit, int quantity, LocalDate expDate) {
        this.type = type;
        this.fruit = fruit;
        this.quantity = quantity;
        this.expDate = expDate;
    }

    public FruitDto() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitDto fruitDto = (FruitDto) o;
        return quantity == fruitDto.quantity
                && type.equals(fruitDto.type)
                && fruit.equals(fruitDto.fruit)
                && expDate.equals(fruitDto.expDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, fruit, quantity, expDate);
    }

    public String getType() {
        return type;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

}
