package parsers;

import dto.AbstractOrder;
import java.time.format.DateTimeFormatter;
import java.util.List;

public interface OrderParser<T extends AbstractOrder> {
    DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    T parse(List<String> data);
}
