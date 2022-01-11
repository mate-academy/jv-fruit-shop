package service;

import dao.RecordDao;
import dao.RecordDaoImpl;
import java.util.List;
import java.util.stream.Collectors;
import model.Record;
import report.FruitBalance;
import strategy.ActivityStrategy;
import strategy.activity.ActivityHandler;

public class ReportCreatorImpl implements ReportCreator {
    private final ActivityStrategy activityStrategy;
    private final RecordDao recordDao = new RecordDaoImpl();

    public ReportCreatorImpl(ActivityStrategy activityStrategy) {
        this.activityStrategy = activityStrategy;
    }

    @Override
    public List<String> createReport() {
        List<Record> listRecords = recordDao.getRecord();
        for (Record record:listRecords) {
            ActivityHandler activityHandler = activityStrategy.get(record.getActivityType());
            activityHandler.apply(record);
        }
        return FruitBalance.FRUIT_BALANCE
                .entrySet()
                .stream()
                .map(string -> string.getKey() + "," + string.getValue())
                .collect(Collectors.toList());
    }
}
