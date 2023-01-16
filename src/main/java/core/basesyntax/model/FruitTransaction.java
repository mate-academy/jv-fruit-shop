package core.basesyntax.model;

import com.opencsv.bean.CsvBindByPosition;

public class FruitTransaction {
    @CsvBindByPosition(position = 0)
    private String operation;
    @CsvBindByPosition(position = 1)
    private String fruit;
    @CsvBindByPosition(position = 2)
    private int quantity;

    public String getOperation() {
        return this.operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }
}
