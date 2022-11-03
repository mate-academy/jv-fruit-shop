package fruitshop.service.parsers;

import java.util.List;

public interface CsvParser {
    List<List<String>> parse(String data);
}
