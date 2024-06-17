package service.parse;

import java.util.List;
import model.FruitRecord;

public interface FruitRecordParser {
    List<FruitRecord> convertToObject(String[] lines);
}
