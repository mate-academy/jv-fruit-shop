package core.basesyntax.service;

import com.opencsv.bean.CsvBindByName;

public class FruitDto {

    @CsvBindByName(column = "type")
    private String type;

    @CsvBindByName(column = "fruit")
    private String fruit;

    @CsvBindByName(column = "quantity")
    private int quantity;

    @CsvBindByName(column = "date")
    private String date;

    public FruitDto(String type, String fruit, int quantity, String date) {
        this.type = type;
        this.fruit = fruit;
        this.quantity = quantity;
        this.date = date;
    }

    public FruitDto() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return type + " " + fruit + " " + quantity + " " + date;
    }
}
