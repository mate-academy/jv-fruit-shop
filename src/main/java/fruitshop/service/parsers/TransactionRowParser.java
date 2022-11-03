package fruitshop.service.parsers;

import java.util.List;

public interface TransactionRowParser {
    void parse(List<List<String>> rows);
}
