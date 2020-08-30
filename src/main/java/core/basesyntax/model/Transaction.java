package core.basesyntax.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import java.time.LocalDate;

public class Transaction {
    @CsvBindByName
    private String type;
    @CsvBindByName
    private String fruit;
    @CsvDate(value = "yyyy-MM-dd")
    @CsvBindByName
    private LocalDate date;
    @CsvBindByName
    private int quantity;

    public void setType(String type) {
        this.type = type;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFruit() {
        return fruit;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }
}
