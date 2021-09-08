package core.basesyntax.operationprovider;

import core.basesyntax.service.operationstrategy.OperationStrategy;
import core.basesyntax.service.reportdb.ReportDataStorage;

import java.util.List;

public class OperationProviderImpl implements OperationProvider{
    @Override
    public void provideOperations(List<String> input,
                                  OperationStrategy operationStrategy,
                                  ReportDataStorage reportDataStorage) {
        for (String s : input) {
            String[] separate = s.split(",");
            operationStrategy.getOperationHandler(separate[0])
                    .provideOperation(reportDataStorage,
                            separate[1], Integer.parseInt(separate[2]));
        }
    }
}
