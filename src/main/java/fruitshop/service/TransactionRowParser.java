package fruitshop.service;

import java.util.List;

public interface TransactionRowParser {
    void parse(List<String> dataLines);
}
