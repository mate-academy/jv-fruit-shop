package service.impl;

import java.util.List;
import model.FruitRecord;

public interface ParsingService {
    List<FruitRecord> parse(List<String> rawData);
}
