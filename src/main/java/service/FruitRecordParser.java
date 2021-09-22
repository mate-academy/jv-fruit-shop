package service;

import java.util.List;
import model.FruitRecord;

public interface FruitRecordParser {
    List<FruitRecord> parse(List<String[]> splitedInformationList);
}
