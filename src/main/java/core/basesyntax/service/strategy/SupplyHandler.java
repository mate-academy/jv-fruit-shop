package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.TypeOfFruit;
import java.util.List;
import java.util.Map;

public class SupplyHandler implements OperationHandler {

    private final FruitDao dao;

    public SupplyHandler(FruitDao dao) {
        this.dao = dao;
    }

    @Override
    public void calculateBalanceAfterActivities() {

        List<FruitTransaction> fruiPurchasetList = dao.getInfoFromPurchaseOperationFruit();
        Map<TypeOfFruit, Integer> balanceMap = dao.getInfoFromBalance();

        for (FruitTransaction fruitInfo : fruiPurchasetList) {
            balanceMap.replace(fruitInfo.getTypeOfFruit(),
                    balanceMap.get(fruitInfo.getTypeOfFruit()) + fruitInfo.getQuantity());
        }
        dao.rebalanced(balanceMap);
    }
}
