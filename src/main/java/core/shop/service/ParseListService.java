package core.shop.service;

import core.shop.model.FruitRecord;
import java.util.List;

public interface ParseListService {
    List<FruitRecord> getFruitRecords(List<String> list);
}
