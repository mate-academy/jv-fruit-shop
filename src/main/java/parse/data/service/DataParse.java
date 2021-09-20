package parse.data.service;

import java.util.List;
import model.FruitRecord;

public interface DataParse {
    boolean parseAndAddToStorage(List<FruitRecord> records);
}
