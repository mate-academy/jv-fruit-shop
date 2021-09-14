package core.basesyntax.service.impl;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.RecordListMakerService;
import java.util.ArrayList;
import java.util.List;

public class RecordListMakerServiceImpl implements RecordListMakerService {
    private ParseService parseService;

    public RecordListMakerServiceImpl() {
        parseService = new ParseServiceImpl();
    }

    @Override
    public List<FruitRecord> getFruitRecordList(List<String> rowsList) {
        List<FruitRecord> recordList = new ArrayList<>();
        for (int i = 1; i < rowsList.size(); i++) {
            recordList.add(parseService.getParsedLine(rowsList.get(i)));
        }
        return recordList;
    }
}
