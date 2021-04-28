package service;

import java.util.List;
import model.FruitRecordDto;

public interface FruitRecordParserService {
    List<FruitRecordDto> getRecord(List<String> stringsFromFile);
}
