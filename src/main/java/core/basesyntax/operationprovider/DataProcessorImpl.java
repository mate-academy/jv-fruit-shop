package core.basesyntax.operationprovider;

import core.basesyntax.service.operationstrategy.OperationStrategy;
import core.basesyntax.service.reportdb.ReportDataStorage;
import java.util.List;

public class DataProcessorImpl implements DataProcessor {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String SPLIT_VALUE = ",";

    @Override
    public void handleInput(List<String> input,
                                  OperationStrategy operationStrategy,
                                  ReportDataStorage reportDataStorage) {
        for (String s : input) {
            String[] separate = s.split(SPLIT_VALUE);
            operationStrategy.getOperationHandler(separate[OPERATION_INDEX])
                    .provideOperation(reportDataStorage,
                            separate[FRUIT_INDEX], Integer.parseInt(separate[AMOUNT_INDEX]));
        }
    }
}
