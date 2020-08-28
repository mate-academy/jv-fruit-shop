package core.basesyntax.services;

import com.opencsv.bean.CsvBindByName;
import java.util.Objects;

public class FruitDto {
    @CsvBindByName(column = "type")
    private String operation;
    @CsvBindByName(column = "fruit")
    private String fruitName;
    @CsvBindByName(column = "quantity")
    private int count;
    @CsvBindByName(column = "date")
    private String data;

    public FruitDto(String operation, String fruitName, int count, String data) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.count = count;
        this.data = data;
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
        return count == fruitDto.count
                && Objects.equals(operation, fruitDto.operation)
                && Objects.equals(fruitName, fruitDto.fruitName)
                && Objects.equals(data, fruitDto.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruitName, count, data);
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
