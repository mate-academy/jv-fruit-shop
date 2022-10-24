package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.DataReaderImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReportWriterImpl;
import core.basesyntax.strategy.ActivityStrategy;
import core.basesyntax.strategy.ActivityStrategyImpl;
import core.basesyntax.strategy.activity.ActivityHandler;
import core.basesyntax.strategy.activity.BalanceActivity;
import core.basesyntax.strategy.activity.PurchaseActivity;
import core.basesyntax.strategy.activity.ReturnActivity;
import core.basesyntax.strategy.activity.SupplyActivity;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final String dataPath = "src/main/resources/data.csv";
        final String reportPath = "src/main/resources/report.csv";

        Map<FruitTransaction.Operation, ActivityHandler> activityHandlerMap = new HashMap<>();
        activityHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceActivity());
        activityHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyActivity());
        activityHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseActivity());
        activityHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnActivity());

        ActivityStrategy activityStrategy = new ActivityStrategyImpl(activityHandlerMap);

        FruitService fruitService = new FruitServiceImpl(activityStrategy,
                new DataReaderImpl(), new ReportWriterImpl());
        fruitService.processData(dataPath, reportPath);
    }
}
