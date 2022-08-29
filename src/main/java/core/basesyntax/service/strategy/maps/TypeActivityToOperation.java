package core.basesyntax.service.strategy.maps;

import core.basesyntax.model.TypeActivity;
import core.basesyntax.service.strategy.handlers.ActivityHandler;
import core.basesyntax.service.strategy.handlers.BalanceActivityHandlerImpl;
import core.basesyntax.service.strategy.handlers.PurchaseActivityHandlerImpl;
import core.basesyntax.service.strategy.handlers.ReturnActivityHandlerImpl;
import core.basesyntax.service.strategy.handlers.SupplyActivityHandlerImpl;
import java.util.HashMap;
import java.util.Map;

public class TypeActivityToOperation {
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
