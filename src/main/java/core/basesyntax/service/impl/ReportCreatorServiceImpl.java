package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageRecordsGetter;
import core.basesyntax.dao.impl.StorageRecordsGetterImpl;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportCreatorService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String CSV_REPORT_TITLE = "fruit,quantity";
    private static final int TITLE_INDEX = 0;
    private static final String FRUIT_TRANSACTION_SEPARATOR = ",";

    private static final StorageRecordsGetter storageRecordsGetter = new StorageRecordsGetterImpl();
    private static final FileWriterService writerService = new FileWriterServiceImpl();

    @Override
    public void create(String fileName) {
        Map<String, Integer> reportMap = storageRecordsGetter.get();
        List<String> dailyReportList = reportMap
                .entrySet()
                .stream()
                .map(entry -> entry.getKey()
                        + FRUIT_TRANSACTION_SEPARATOR
                        + entry.getValue())
                .collect(Collectors.toList());
        dailyReportList.add(TITLE_INDEX, CSV_REPORT_TITLE);
        writerService.writeToFile(dailyReportList, fileName);
    }
}
