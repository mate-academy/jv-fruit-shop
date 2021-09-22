package core.basesyntax.service;

import core.basesyntax.Record;
import core.basesyntax.Storage;
import core.basesyntax.activity.ActivityStrategy;
import java.util.List;

public class FruitService {
    private final WriterService writerService;
    private final ActivityStrategy activityStrategy;
    private final List<Record> records;

    public FruitService(List<Record> recordList, WriterService writerService,
                        ActivityStrategy activityStrategy) {
        this.records = recordList;
        this.writerService = writerService;
        this.activityStrategy = activityStrategy;
    }

    public void applyOperationsOnFruitsRecords() {
        for (Record record : records) {
            activityStrategy.getActivity(record.getActivity())
                    .activity(record.getFruit(), record.getAmount());
        }
    }

    public void generateReport() {
        writerService.writeData(Storage.fruitStorage);
    }
}
