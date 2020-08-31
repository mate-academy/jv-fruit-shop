package parsers;

import dto.Order;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

public class OrderParser {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Order parse(String line) {
        Order order = new Order();
        List<String> data = Arrays.asList(line.split(","));
        try {
            order.setType(data.get(0));
            order.setProductName(data.get(1));
            order.setQuantity(Integer.parseInt(data.get(2)));
            order.setDate(LocalDate.parse(data.get(3), formatter));
        } catch (NumberFormatException
                | DateTimeParseException e) {
            throw new RuntimeException("Wrong input order/format!");
        }
        return order;
    }

}
