package core.basesyntax.service.impl;

import core.basesyntax.service.ProcessService;
import core.basesyntax.strategy.ActivitiesStrategy;
import java.util.List;
import java.util.function.Consumer;

public class ProcessServiceCsvImpl implements ProcessService {
    private static final String CSV_PUNCTUATION_MARK = ",";
    private static final Integer CSV_ACTIVITY_POSITION = 0;
    private static final Integer CSV_PRODUCT_POSITION = 1;
    private static final Integer CSV_AMOUNT_POSITION = 2;
    private static ActivitiesStrategy activitiesStrategy;
    private static DataLineProcessService dataLineProcessService;

    public ProcessServiceCsvImpl(ActivitiesStrategy activitiesStrategy,
                                 DataLineProcessService dataLineProcessService) {
        this.activitiesStrategy = activitiesStrategy;
        this.dataLineProcessService = dataLineProcessService;
    }

    @Override
    public void processInfo(List<String> dataList) {
        dataList.stream()
                .map(data -> data.split(CSV_PUNCTUATION_MARK))
                .forEach(dataLineProcessService);
    }

    public static final class DataLineProcessService implements Consumer<String[]> {
        @Override
        public void accept(String[] dataLine) {
            activitiesStrategy.get(dataLine[CSV_ACTIVITY_POSITION])
                    .updateProductInfo(dataLine[CSV_PRODUCT_POSITION],
                            Integer.valueOf(dataLine[CSV_AMOUNT_POSITION]));
        }
    }
}
