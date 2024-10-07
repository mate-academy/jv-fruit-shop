package service.parse;

import model.FruitRecord;

import java.util.List;

public interface DataParser {
    List<FruitRecord> parseFruitRecords(List<String> data);
}
