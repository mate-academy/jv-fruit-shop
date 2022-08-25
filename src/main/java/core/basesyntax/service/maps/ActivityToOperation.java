package core.basesyntax.service.maps;

import core.basesyntax.model.TypeActivity;
import core.basesyntax.service.strategy.ActivityHandler;
import core.basesyntax.service.strategy.BalanceActivityHandlerImpl;
import core.basesyntax.service.strategy.PurchaseActivityHandlerImpl;
import core.basesyntax.service.strategy.ReturnActivityHandlerImpl;
import core.basesyntax.service.strategy.SupplyActivityHandlerImpl;
import java.util.HashMap;
import java.util.Map;

public class ActivityToOperation {
    private static final Map<TypeActivity, ActivityHandler> map = new HashMap<>();

    static {
        map.put(TypeActivity.BALANCE, new BalanceActivityHandlerImpl());
        map.put(TypeActivity.SUPPLY, new SupplyActivityHandlerImpl());
        map.put(TypeActivity.PURCHASE, new PurchaseActivityHandlerImpl());
        map.put(TypeActivity.RETURN, new ReturnActivityHandlerImpl());
    }

    public static Map<TypeActivity, ActivityHandler> getMap() {
        return map;
    }
}
