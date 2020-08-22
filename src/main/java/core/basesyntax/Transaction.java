package core.basesyntax;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.opencsv.bean.CsvDate;
import java.time.LocalDate;

public class Transaction {
    @CsvCustomBindByName(column = "type", converter = ConvertOperation.class)
    private Operation operation;
    @CsvBindByName
    private String fruit;
    @CsvBindByName
    private int quantity;
    @CsvBindByName
    @CsvDate("yyyy-MM-dd")
    private LocalDate date;

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getDate() {
        return date;
    }
}
