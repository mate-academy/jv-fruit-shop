package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.activity.ActivityHandler;
import core.basesyntax.service.activity.BalanceActivityHandler;
import core.basesyntax.service.activity.PurchaseActivityHandler;
import core.basesyntax.service.activity.ReturnActivityHandler;
import core.basesyntax.service.activity.SupplyActivityHandler;
import core.basesyntax.strategy.ActivityStrategyImpl;
import java.util.Map;

public class Main {
    // HINT: In the `public static void main(String[] args)`
    // it is better to create instances of your classes,
    // and call their methods, but do not write any business logic in the `main` method!
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, ActivityHandler> activityHandlerMap =
                Map.of(FruitTransaction.Operation.BALANCE, new BalanceActivityHandler(),
                        FruitTransaction.Operation.PURCHASE, new PurchaseActivityHandler(),
                        FruitTransaction.Operation.RETURN, new ReturnActivityHandler(),
                        FruitTransaction.Operation.SUPPLY, new SupplyActivityHandler());
        FruitService fruitService = new FruitService(new ActivityStrategyImpl(activityHandlerMap));
        FileService fileService = new FileService();
        fruitService.makeReport(fileService.readFromFile());
        fileService.writeReport();
    }
}
