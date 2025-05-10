package core.basesyntax;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ActivityStrategyImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.activity.Activity;
import core.basesyntax.service.activity.BalanceActivity;
import core.basesyntax.service.activity.PurchaseActivity;
import core.basesyntax.service.activity.ReturnActivity;
import core.basesyntax.service.activity.SupplyActivity;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Fruit.Type, Activity> typeActivityMap = new HashMap<>();
        typeActivityMap.put(Fruit.Type.BALANCE, new BalanceActivity());
        typeActivityMap.put(Fruit.Type.PURCHASE, new PurchaseActivity());
        typeActivityMap.put(Fruit.Type.RETURN, new ReturnActivity());
        typeActivityMap.put(Fruit.Type.SUPPLY, new SupplyActivity());

        ReportService reportService = new ReportServiceImpl(new FruitDaoImpl(),
                new ActivityStrategyImpl(typeActivityMap));
        reportService.report();
    }
}
