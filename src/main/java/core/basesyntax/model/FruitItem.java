package core.basesyntax.model;

import com.opencsv.bean.CsvBindByName;

public class FruitItem {
    @CsvBindByName(column = "fruit", required = true)
    private String name;
    @CsvBindByName(column = "quantity", required = true)
    private int quantity;

    public FruitItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "FruitItem{"
                + "name='" + name + '\''
                + ", quantity=" + quantity
                + '}';
    }
}
