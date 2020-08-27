package core.basesyntax;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import core.basesyntax.converter.LocalDateConverter;
import java.time.LocalDate;
import java.util.Objects;

public class Order {

    @CsvBindByName(column = "type")
    private char type;
    @CsvBindByName(column = "fruit")
    private String fruitName;
    @CsvBindByName(column = "quantity")
    private int quantity;
    @CsvCustomBindByName(column = "date", converter = LocalDateConverter.class)
    private LocalDate date;

    public void setType(char type) {
        this.type = type;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public char getType() {
        return type;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return type == order.type
                && quantity == order.quantity
                && Objects.equals(fruitName, order.fruitName)
                && Objects.equals(date, order.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, fruitName, quantity, date);
    }

    @Override
    public String toString() {
        return "Order{"
                + "type=" + type
                + ", fruitName='" + fruitName + '\''
                + ", quantity=" + quantity
                + ", date=" + date + '}';
    }
}
