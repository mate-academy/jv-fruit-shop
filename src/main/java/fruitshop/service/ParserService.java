package fruitshop.service;

import fruitshop.model.FruitTransaction;
import java.util.List;

public interface ParserService {
    List<FruitTransaction> parse(List<String> data);
}
