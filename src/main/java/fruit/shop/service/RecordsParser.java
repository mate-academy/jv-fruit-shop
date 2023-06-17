package fruit.shop.service;

import fruit.shop.model.FruitTransaction;
import java.util.List;

public interface RecordsParser {
    List<FruitTransaction> parseRecords(List<String> records);
}
