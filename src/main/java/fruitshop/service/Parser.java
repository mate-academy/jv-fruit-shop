package fruitshop.service;

import fruitshop.model.DataLine;
import java.util.List;

public interface Parser {
    List<DataLine> parseStringToDataObject(List<String> stringList);
}
