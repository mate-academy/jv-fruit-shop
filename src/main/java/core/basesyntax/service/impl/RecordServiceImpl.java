package core.basesyntax.service.impl;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.RecordService;
import java.util.ArrayList;
import java.util.List;

public class RecordServiceImpl implements RecordService {
    private final ParseService parseService = new ParseServiceImpl();

    @Override
    public List<FruitRecord> getFruitRecords(List<String> data) {
        List<FruitRecord> tmp = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            tmp.add(parseService.parseData(data.get(i)));
        }
        return tmp;
    }
}
