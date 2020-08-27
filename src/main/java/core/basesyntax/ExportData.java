package core.basesyntax;

import com.opencsv.bean.CsvBindByName;
import java.util.Objects;

public class ExportData {
    @CsvBindByName
    private int quantity;
    @CsvBindByName
    private String name;

    public ExportData(int quantity, String name) {
        this.quantity = quantity;
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExportData that = (ExportData) o;
        return quantity == that.quantity
                && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, name);
    }

    @Override
    public String toString() {
        return "ExportData{"
                + "quantity=" + quantity
                + ", name='" + name + '\'' + '}';
    }
}
