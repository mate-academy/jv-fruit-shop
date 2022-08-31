package core.basesyntax.service.strategy.maps;

import core.basesyntax.dao.ActivityDaoDb;
import core.basesyntax.model.TypeActivity;
import core.basesyntax.service.strategy.handlers.ActivityHandler;
import core.basesyntax.service.strategy.handlers.BalanceActivityHandlerImpl;
import core.basesyntax.service.strategy.handlers.PurchaseActivityHandlerImpl;
import core.basesyntax.service.strategy.handlers.ReturnActivityHandlerImpl;
import core.basesyntax.service.strategy.handlers.SupplyActivityHandlerImpl;
import java.util.HashMap;
import java.util.Map;

public class TypeActivityToOperation {
    private final Map<TypeActivity, ActivityHandler> map = new HashMap<>();

    public TypeActivityToOperation(ActivityDaoDb activityDaoDb) {
        map.put(TypeActivity.BALANCE, new BalanceActivityHandlerImpl(activityDaoDb));
        map.put(TypeActivity.SUPPLY, new SupplyActivityHandlerImpl(activityDaoDb));
        map.put(TypeActivity.PURCHASE, new PurchaseActivityHandlerImpl(activityDaoDb));
        map.put(TypeActivity.RETURN, new ReturnActivityHandlerImpl(activityDaoDb));
    }

    public Map<TypeActivity, ActivityHandler> getMap() {
        return map;
    }
}
