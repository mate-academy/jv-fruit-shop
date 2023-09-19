package fruitshop.service;

import fruitshop.model.FruitTransaction;
import java.util.List;

public interface DataParser {
    List<FruitTransaction> parseStringToDataObject(List<String> stringList);
}
