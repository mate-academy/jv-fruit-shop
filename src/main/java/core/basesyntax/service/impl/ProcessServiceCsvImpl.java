package core.basesyntax.service.impl;

import core.basesyntax.constants.Activity;
import core.basesyntax.service.ProcessService;
import core.basesyntax.strategy.ActivitiesStrategy;
import core.basesyntax.strategy.ActivitiesStrategyImpl;
import core.basesyntax.strategy.handlers.ActivityHandler;
import core.basesyntax.strategy.handlers.impl.BalanceActivityHandler;
import core.basesyntax.strategy.handlers.impl.PurchaseActivityHandler;
import core.basesyntax.strategy.handlers.impl.ReturnActivityHandler;
import core.basesyntax.strategy.handlers.impl.SupplyActivityHandler;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ProcessServiceCsvImpl implements ProcessService {
    private static final String CSV_PUNCTUATION_MARK = ",";
    private static final Integer CSV_ACTIVITY_POSITION = 0;
    private static final Integer CSV_PRODUCT_POSITION = 1;
    private static final Integer CSV_AMOUNT_POSITION = 2;
    private final Map<String, ActivityHandler> activitiesStrategyMap = Map.of(
            Activity.BALANCE.getActivity(), new BalanceActivityHandler(),
            Activity.PURCHASE.getActivity(), new PurchaseActivityHandler(),
            Activity.RETURN.getActivity(), new ReturnActivityHandler(),
            Activity.SUPPLY.getActivity(), new SupplyActivityHandler()
            );
    private final ActivitiesStrategy activitiesStrategy =
            new ActivitiesStrategyImpl(activitiesStrategyMap);
    private final DataLineProcessService dataLineProcessService =
            new DataLineProcessService();

    @Override
    public void processInfo(List<String> dataList) {
        dataList.stream()
                .map(data -> data.split(CSV_PUNCTUATION_MARK))
                .forEach(dataLineProcessService);
    }

    private final class DataLineProcessService implements Consumer<String[]> {
        @Override
        public void accept(String[] dataLine) {
            activitiesStrategy.get(dataLine[CSV_ACTIVITY_POSITION])
                    .updateProductInfo(dataLine[CSV_PRODUCT_POSITION],
                            Integer.valueOf(dataLine[CSV_AMOUNT_POSITION]));
        }
    }
}
